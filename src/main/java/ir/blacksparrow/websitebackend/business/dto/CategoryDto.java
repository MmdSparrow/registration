package ir.blacksparrow.websitebackend.business.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private Long id;
    private String code;
    private String title;

    public CategoryDto(String code, String title) {
        this.code = code;
        this.title = title;
    }
}
