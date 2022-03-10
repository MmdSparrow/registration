package ir.blacksparrow.websitebackend.business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
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
