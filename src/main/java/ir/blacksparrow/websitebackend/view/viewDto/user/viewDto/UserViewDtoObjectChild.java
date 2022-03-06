package ir.blacksparrow.websitebackend.view.viewDto.user.viewDto;

//import com.sun.istack.NotNull;
import ir.blacksparrow.websitebackend.view.viewDto.person.viewDto.PersonViewDto;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserViewDtoObjectChild {
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Email
    private String emailAddress;

    @NotNull
    private PersonViewDto person;
}
