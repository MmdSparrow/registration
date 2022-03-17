package ir.blacksparrow.websitebackend.view.controller.user;

import ir.blacksparrow.websitebackend.business.dto.PersonDto;
import ir.blacksparrow.websitebackend.business.dto.UserDto;
import ir.blacksparrow.websitebackend.business.sevice.categoryElement.CategoryElementService;
import ir.blacksparrow.websitebackend.business.sevice.registration.RegistrationService;
import ir.blacksparrow.websitebackend.view.controller.ParentController;
import ir.blacksparrow.websitebackend.view.viewDto.user.viewDto.UserViewDtoObjectChild;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController extends ParentController {

    private final RegistrationService registrationService;
    private final CategoryElementService categoryElementService;

    public UserController(ModelMapper modelMapper, RegistrationService registrationService, CategoryElementService categoryElementService) {
        super(modelMapper);
        this.registrationService = registrationService;
        this.categoryElementService = categoryElementService;
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
                getModelMapper().map(request.getPerson(), PersonDto.class),
                categoryElementService.getCategoryElementById(request.getCategoryElementId()).orElse(null)
        ));
    }

    @GetMapping(
            path = "/confirm",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String confirm(
//            @RequestHeader("confirmToken") String confirmToken
            @RequestParam("confirmToken") String confirmToken
    ) throws IllegalAccessException {
        return registrationService.confirmToken(confirmToken);
    }

}

