package ir.blacksparrow.websitebackend.view.controller.user;

import ir.blacksparrow.websitebackend.business.dto.PersonDto;
import ir.blacksparrow.websitebackend.business.dto.UserDto;
import ir.blacksparrow.websitebackend.business.sevice.registrationService.RegistrationService;
import ir.blacksparrow.websitebackend.view.controller.ParentController;
import ir.blacksparrow.websitebackend.view.viewDto.user.viewDto.UserViewDtoObjectChild;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController extends ParentController {

    private final RegistrationService registrationService;

    public UserController(ModelMapper modelMapper, RegistrationService registrationService) {
        super(modelMapper);
        this.registrationService = registrationService;
    }

    @PostMapping
    public String register(
            @Valid @RequestBody UserViewDtoObjectChild request
    ) throws IllegalAccessException {
//        return registrationService.register(getMapper().map(request, UserDto.class)); //todo
        return registrationService.register(new UserDto(
                request.getUsername(),
                request.getPassword(),
                request.getEmailAddress(),
                getModelMapper().map(request.getPerson(), PersonDto.class)
        ));
    }
}
