package ir.blacksparrow.websitebackend.business.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
    private Long id;
    private String code;
    private String title;
}
