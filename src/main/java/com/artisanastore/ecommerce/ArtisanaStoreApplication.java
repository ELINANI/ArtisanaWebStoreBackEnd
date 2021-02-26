package com.artisanastore.ecommerce;
import com.artisanastore.ecommerce.Domaine.RoleVO;
import com.artisanastore.ecommerce.Mail.MailToSend;
import com.artisanastore.ecommerce.Service.IAdmin;
import com.artisanastore.ecommerce.Service.IRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
public class ArtisanaStoreApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ArtisanaStoreApplication.class, args);
    }
    @Autowired
    private IAdmin iAdmin;
    @Autowired
    private IRole iRole;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean
    public WebMvcConfigurer corsConfigure(){
        return  new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*").allowedMethods("*").allowedOriginPatterns("*");
            }
        };
    }
    @Override
    public void run(String... args) throws Exception {
        //RoleVO r = new RoleVO(1 ,"Client");
        //iRole.addRole(r);
    }
}
