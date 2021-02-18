package com.artisanastore.ecommerce.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class AspectImp {

    @Before("@annotation(Tracibilite)")
    public void runTrace(JoinPoint joinPoint){
        String methodeName = joinPoint.getSignature().getName();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        SimpleDateFormat d = new SimpleDateFormat("yyyy-mm-dd");
        String date = d.format(new Date());
       try{
           BufferedWriter bw = new BufferedWriter(new FileWriter("Log.txt"));
           bw.write("the methode " + methodeName +"was used by " + auth.getName() + "At :"+ date +"\n");
           bw.close();
       }catch (Exception e){
           System.out.println(e.getMessage());
       }

    }
}
