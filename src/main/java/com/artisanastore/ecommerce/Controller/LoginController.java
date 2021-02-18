package com.artisanastore.ecommerce.Controller;

import com.artisanastore.ecommerce.Domaine.ArtisanVO;
import com.artisanastore.ecommerce.Domaine.AuthRequest;
import com.artisanastore.ecommerce.Domaine.ClientVO;
import com.artisanastore.ecommerce.Domaine.PersonneVO;
import com.artisanastore.ecommerce.Mail.MailToSend;
import com.artisanastore.ecommerce.Models.Artisan;
import com.artisanastore.ecommerce.Models.Email;
import com.artisanastore.ecommerce.Service.IArtisan;
import com.artisanastore.ecommerce.Service.IClient;
import com.artisanastore.ecommerce.Util.JwtUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Collection;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager ;
    @Autowired
    private IClient iClient ;

    @Autowired
    private IArtisan iArtisan;
    @Autowired
    private MailToSend mail;
    @GetMapping("/")
    public Object welcome(){
        String authorization  = "";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         System.out.println(auth.getAuthorities());
         Collection<? extends  GrantedAuthority> list = auth.getAuthorities();
         for(GrantedAuthority ff  : list){
             authorization = ff.getAuthority() ;
             System.out.println(authorization);
         }
        if(authorization.equals("Client")){
            ClientVO clientVO = iClient.findByEmail(auth.getName());
            System.out.println(clientVO);
            return   clientVO ;
        }else if(authorization == "Artisan"){
            ArtisanVO artisanVO = iArtisan.findByEmail(auth.getName());
            return  artisanVO ;
        }
        else {
            return  null;
        }
    }
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPwd())
            );
        }catch (Exception e) {
            throw  new Exception("Invalid username or passwrod");
        }
        return jwtUtil.generateToken(authRequest.getEmail());
    }
    @PostMapping("/registerClient")
    public ResponseEntity<String> registerClient(@RequestParam("photoProfile")MultipartFile photoProfile ,@RequestParam("client") String object){
        Gson g = new Gson();
        ClientVO vo = g.fromJson(object,ClientVO.class);
        iClient.addClient(photoProfile , vo);
         return new ResponseEntity<String>("Register" , HttpStatus.CREATED);
    }
    @PostMapping("/registerArtisan")
    public ResponseEntity<String> addArtisan(@RequestParam("photoProfile") MultipartFile photoProfile , @RequestParam("artisan") String object){
        System.out.println(object);
        Gson g = new Gson();
        ArtisanVO vo = g.fromJson(object, ArtisanVO.class);
        iArtisan.addArtisan(photoProfile , vo);
        return new ResponseEntity<String>("Register" , HttpStatus.CREATED);
    }
    @PostMapping("/sendMailToVerify")
    public ResponseEntity<String>SendMail(@RequestBody Email mailVerify){
         mail.sendEmail(mailVerify.getEmail() ,"votre code de verification" ,"102030");
        return new ResponseEntity<String>("mail sent" ,HttpStatus.OK);
    }
}
