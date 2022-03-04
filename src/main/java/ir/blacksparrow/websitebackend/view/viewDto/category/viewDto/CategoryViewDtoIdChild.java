package ir.blacksparrow.websitebackend.view.viewDto.category.viewDto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryViewDtoIdChild {


    private Long id;
    private String code;
    private String title;
    private List<Long> categoryElementIdList;
}
