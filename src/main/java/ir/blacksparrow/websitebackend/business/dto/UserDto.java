package ir.blacksparrow.websitebackend.business.dto;

import ir.blacksparrow.websitebackend.dataModel.CategoryElementEntity;
import ir.blacksparrow.websitebackend.dataModel.PersonEntity;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private String emailAddress;
    private PersonDto person;
    private CategoryElementDto categoryElement;
    private Boolean locked;
    private Boolean enabled;
}
