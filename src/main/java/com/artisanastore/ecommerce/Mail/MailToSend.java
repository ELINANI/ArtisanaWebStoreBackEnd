package com.artisanastore.ecommerce.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailToSend {

    @Autowired
    private JavaMailSender javaMailSende;

    public  void sendEmail(String email ,String subject ,String Content){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("mowglifianso@gmail.com");
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(Content);
        javaMailSende.send(simpleMailMessage);
    }
    public void sendMailWithAttachement(String email, String subject , String Content , File file) throws MessagingException {
          String name = file.getName();
          MimeMessage msg = javaMailSende.createMimeMessage();
          MimeMessageHelper helper = new MimeMessageHelper(msg,true);
          helper.setTo(email);
          helper.setFrom("mowglifianso@gmail.com");
          helper.setSubject(subject);
          helper.setText(Content);
          helper.addAttachment(name ,file);
          javaMailSende.send((MimeMessagePreparator) helper);

    }

}
