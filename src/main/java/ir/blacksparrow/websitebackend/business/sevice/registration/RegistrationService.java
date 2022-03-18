package ir.blacksparrow.websitebackend.business.sevice.registration;

import ir.blacksparrow.websitebackend.business.dto.TokenConfirmationDto;
import ir.blacksparrow.websitebackend.business.dto.TokenConfirmationDtoChild;
import ir.blacksparrow.websitebackend.business.dto.UserDto;
import ir.blacksparrow.websitebackend.business.sevice.email.EmailService;
import ir.blacksparrow.websitebackend.business.sevice.tokenConfirmation.TokenConfirmationService;
import ir.blacksparrow.websitebackend.business.sevice.user.UserService;
import ir.blacksparrow.websitebackend.business.sevice.emailValidator.EmailValidatorService;
import ir.blacksparrow.websitebackend.repository.tokenConfirmation.TokenConfirmationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class RegistrationService implements IRegistrationService{

    private final UserService userService;
    private final EmailValidatorService emailValidatorService;
    private final TokenConfirmationRepository tokenConfirmationRepository;
    private final TokenConfirmationService tokenConfirmationService;
    private final EmailService emailService;

    @Override
    public String register(UserDto request) throws IllegalAccessException {
        boolean isValidEmail = emailValidatorService.test(request.getEmailAddress());
        if(!isValidEmail){
            throw new IllegalAccessException("email not valid");
        }
        System.out.println(request.getCategoryElement().toString());
        String token=userService.signupUser(
                new UserDto(
                        request.getUsername(),
                        request.getPassword(),
                        request.getEmailAddress(),
                        request.getPerson(),
                        request.getCategoryElement()
                )
        );
        String link = "http://localhost:8080/user/confirm?confirmToken=" + token;
        emailService.send(request.getEmailAddress(), emailBuilder(request.getPerson().getFirstName(), link));
        return token;
    }

    private String emailBuilder(String name, String link){
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm your email</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Thank you for registering. Please click on the below link to activate your account: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\"" + link + "\">Activate Now</a> </p></blockquote>\n Link will expire in 15 minutes. <p>See you soon</p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }

//    @Transactional
    @Override
    public String confirmToken(String token){
        TokenConfirmationDtoChild tokenConfirmationDtoChild= tokenConfirmationRepository
                .findByToken(token)
                .orElseThrow(()->new IllegalStateException("token not found!"));

//        if(tokenConfirmationDtoChild.getConfirmTime()!=null){
//            throw new IllegalStateException("email already confirmed!");
//        }


        LocalDateTime expireTime = tokenConfirmationDtoChild.getExpireTime();

        if(expireTime.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("token expired");
        }
        System.out.println(tokenConfirmationDtoChild.toString());
        tokenConfirmationService.setConfirmTime(tokenConfirmationDtoChild);
        try{
            System.out.println("wtf.....................................................");
            System.out.println(tokenConfirmationDtoChild.getUser().getEmailAddress());
            System.out.println("wtf.....................................................");

            userService.enableUser(tokenConfirmationDtoChild.getUser().getEmailAddress());
        }catch (Exception ignored){

        }

        return "confirmed";
    }
}
