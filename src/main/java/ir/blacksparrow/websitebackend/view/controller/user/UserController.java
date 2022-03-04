package ir.blacksparrow.websitebackend.view.controller.user;

import ir.blacksparrow.websitebackend.view.controller.ParentController;
import ir.blacksparrow.websitebackend.view.viewDto.user.viewDto.UserViewDtoObjectChild;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends ParentController {
    public String register(
            @RequestBody UserViewDtoObjectChild request
    ){
        return null;
    }
}
