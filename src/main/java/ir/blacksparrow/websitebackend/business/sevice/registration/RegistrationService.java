package ir.blacksparrow.websitebackend.business.sevice.registration;

import ir.blacksparrow.websitebackend.business.dto.TokenConfirmationDto;
import ir.blacksparrow.websitebackend.business.dto.TokenConfirmationDtoChild;
import ir.blacksparrow.websitebackend.business.dto.UserDto;
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

    @Override
    public String register(UserDto request) throws IllegalAccessException {
        boolean isValidEmail = emailValidatorService.test(request.getEmailAddress());
        if(!isValidEmail){
            throw new IllegalAccessException("email not valid");
        }
        System.out.println(request.getCategoryElement().toString());
        return userService.signupUser(
                new UserDto(
                        request.getUsername(),
                        request.getPassword(),
                        request.getEmailAddress(),
                        request.getPerson(),
                        request.getCategoryElement()
                )
        );
    }

    @Transactional
    @Override
    public String confirmToken(String token){
        TokenConfirmationDtoChild tokenConfirmationDtoChild= tokenConfirmationRepository
                .findByToken(token)
                .orElseThrow(()->new IllegalStateException("token not found!"));

        if(tokenConfirmationDtoChild.getConfirmTime()!=null){
            throw new IllegalStateException("email already confirmed!");
        }


        LocalDateTime expireTime = tokenConfirmationDtoChild.getExpireTime();

        if(expireTime.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("token expired");
        }

        tokenConfirmationService.setConfirmTime(tokenConfirmationDtoChild);
        try{
            userService.enableUser(tokenConfirmationDtoChild.getUser().getEmailAddress());
        }catch (Exception ignored){

        }

        return "confirmed";
    }
}
