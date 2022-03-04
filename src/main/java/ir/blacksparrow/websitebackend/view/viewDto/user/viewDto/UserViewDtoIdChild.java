package ir.blacksparrow.websitebackend.view.viewDto.user.viewDto;

import ir.blacksparrow.websitebackend.dataModel.PersonEntity;
import ir.blacksparrow.websitebackend.view.viewDto.person.viewDto.PersonViewDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserViewDtoIdChild {
    private String username;
    private String password;
    private String emailAddress;
    private Long personId;
}
