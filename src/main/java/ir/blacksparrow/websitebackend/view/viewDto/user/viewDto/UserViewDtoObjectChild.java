package ir.blacksparrow.websitebackend.view.viewDto.user.viewDto;

import com.sun.istack.NotNull;
import ir.blacksparrow.websitebackend.view.viewDto.person.viewDto.PersonViewDto;
import lombok.Data;

import javax.validation.constraints.Email;

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
