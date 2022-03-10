package ir.blacksparrow.websitebackend.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryElementDto {
    private Long id;
    private String code;
    private String title;
    private CategoryDto category;

    public CategoryElementDto(String code, String title, CategoryDto category) {
        this.code = code;
        this.title = title;
        this.category = category;
    }
}
