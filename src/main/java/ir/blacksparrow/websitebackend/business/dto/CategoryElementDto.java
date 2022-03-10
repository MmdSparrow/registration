package ir.blacksparrow.websitebackend.business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CategoryElementDto {
    private Long id;
    private String code;
    private String title;
    private CategoryDto category;
}
