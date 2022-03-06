package ir.blacksparrow.websitebackend.view.viewDto.person.viewDto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class PersonViewDto {
    @NotNull
    private String nationalId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Date birthday;
    private double balance;
}
