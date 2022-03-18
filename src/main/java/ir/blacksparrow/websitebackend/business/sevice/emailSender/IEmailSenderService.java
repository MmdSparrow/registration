package ir.blacksparrow.websitebackend.business.sevice.emailSender;

public interface IEmailSenderService {
    void send(String to, String email);
}
