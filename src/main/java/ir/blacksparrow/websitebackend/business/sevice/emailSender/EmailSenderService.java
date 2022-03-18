package ir.blacksparrow.websitebackend.business.sevice.emailSender;

import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@AllArgsConstructor
@Service
public class EmailSenderService implements IEmailSenderService {
//    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender;

    @Async
    @Override
    public void send(String to, String email) {
        try{
            MimeMessage mimeMessage=mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
            messageHelper.setText(email, true);
            messageHelper.setFrom("temp.sender.317@gmail.com");
            messageHelper.setTo(to);
            messageHelper.setSubject("Email Confirmation");
            mailSender.send(mimeMessage);
         }catch (MessagingException e){
//            System.out.println(e.getMessage());
        }
    }
}
