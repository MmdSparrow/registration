package ir.blacksparrow.websitebackend.view.viewDto.categoryElement.viewDto;

import ir.blacksparrow.websitebackend.view.viewDto.category.viewDto.CategoryViewDto;
import lombok.Data;

@Data
public class CategoryElement {
    private String code;
    private String title;
    private CategoryViewDto category;
}
