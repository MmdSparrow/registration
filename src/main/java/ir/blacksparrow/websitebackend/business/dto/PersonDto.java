package ir.blacksparrow.websitebackend.business.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PersonDto {
    private String nationalId;
    private String firstName;
    private String lastName;
    private Date birthday;
    private double balance;
}
