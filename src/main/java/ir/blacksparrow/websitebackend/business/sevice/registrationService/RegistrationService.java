package ir.blacksparrow.websitebackend.business.sevice.registrationService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import ir.blacksparrow.websitebackend.view.viewDto.user.viewDto.UserViewDtoIdChild;
import ir.blacksparrow.websitebackend.view.viewDto.user.viewDto.UserViewDtoObjectChild;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public String register(UserViewDtoObjectChild request){
        return "works";
    }
}
