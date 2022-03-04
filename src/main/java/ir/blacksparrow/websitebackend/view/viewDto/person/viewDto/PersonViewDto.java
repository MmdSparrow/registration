package ir.blacksparrow.websitebackend.view.viewDto.person.viewDto;

import lombok.Data;

import java.util.Date;

@Data
public class PersonViewDto {
    private String nationalId;
    private String firstName;
    private String lastName;
    private Date birthday;
    private double balance;
}
