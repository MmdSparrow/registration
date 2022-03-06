package ir.blacksparrow.websitebackend.view.viewDto.user.viewDto;

//import com.sun.istack.NotNull;
import ir.blacksparrow.websitebackend.dataModel.PersonEntity;
import ir.blacksparrow.websitebackend.view.viewDto.person.viewDto.PersonViewDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
public class UserViewDtoIdChild {
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Email
    private String emailAddress;

    @NotNull
    private Long personId;
}
