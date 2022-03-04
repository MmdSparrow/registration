package ir.blacksparrow.websitebackend.view.viewDto.category.viewDto;

import ir.blacksparrow.websitebackend.business.dto.CategoryElementDto;
import lombok.Data;

import java.util.List;

@Data
public class CategoryViewDtoObjectChild {
    private Long id;
    private String code;
    private String title;
    private List<CategoryElementDto> categoryElementList;
}
