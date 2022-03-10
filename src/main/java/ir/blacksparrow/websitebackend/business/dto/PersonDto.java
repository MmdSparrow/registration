package ir.blacksparrow.websitebackend.business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class PersonDto {
    private String nationalId;
    private String firstName;
    private String lastName;
    private Date birthday;
    private double balance;
}
