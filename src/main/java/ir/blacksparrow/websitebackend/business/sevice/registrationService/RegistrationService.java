package ir.blacksparrow.websitebackend.business.sevice.registrationService;

import ir.blacksparrow.websitebackend.business.dto.UserDto;
import ir.blacksparrow.websitebackend.business.sevice.emailValidator.EmailValidatorService;
import ir.blacksparrow.websitebackend.business.sevice.user.UserService;
import ir.blacksparrow.websitebackend.view.viewDto.user.viewDto.UserViewDtoObjectChild;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistrationService implements IRegistrationService{

    private final UserService userService;
    private final EmailValidatorService emailValidatorService;

    public String register(UserDto request) throws IllegalAccessException {
        boolean isValidEmail = emailValidatorService.test(request.getEmailAddress());
        if(!isValidEmail){
            throw new IllegalAccessException("email not valid");
        };
        return userService.signupUser(
                new UserDto(
                        request.getUsername(),
                        request.getPassword(),
                        request.getEmailAddress(),
                        request.getPerson()
                )
        );
    }
}
