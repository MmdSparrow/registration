package ir.blacksparrow.websitebackend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static ir.blacksparrow.websitebackend.constant.Constant.EmailSender.*;

@SpringBootApplication
@EnableSwagger2
public class WebsiteBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteBackendApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl javaMailSender= new JavaMailSenderImpl();
//        javaMailSender.setUsername(SENDER_EMAIL_ADDRESS);
//        javaMailSender.setPassword(SENDER_EMAIL_PASSWORD);
        return javaMailSender;
    }
}
