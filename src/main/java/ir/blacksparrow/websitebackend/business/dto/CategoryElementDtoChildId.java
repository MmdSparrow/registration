package ir.blacksparrow.websitebackend.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryElementDtoChildId {
    private Long id;
    private String code;
    private String title;
    private long categoryId;

}