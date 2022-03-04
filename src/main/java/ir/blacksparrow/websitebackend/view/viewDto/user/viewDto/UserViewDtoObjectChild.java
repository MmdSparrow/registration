package ir.blacksparrow.websitebackend.view.viewDto.user.viewDto;

import ir.blacksparrow.websitebackend.view.viewDto.person.viewDto.PersonViewDto;
import lombok.Data;

@Data
public class UserViewDtoObjectChild {
    private String username;
    private String password;
    private String emailAddress;
    private PersonViewDto person;
}
