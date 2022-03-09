package ir.blacksparrow.websitebackend.business.dto;

import lombok.Data;

@Data
public class CategoryElementDto {
    private Long id;
    private String code;
    private String title;
    private CategoryDto category;
}
