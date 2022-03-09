package ir.blacksparrow.websitebackend.business.sevice.categoryElement;

import ir.blacksparrow.websitebackend.business.dto.CategoryElementDto;

import java.util.List;

public interface ICategoryElementService {
    List<CategoryElementDto> getCategoryElementList();
    List<CategoryElementDto> searchCategoryElement(String code,String title,Long categoryId,String categoryCode);
    CategoryElementDto getCategoryElementById(long id);

    CategoryElementDto insertAndUpdateCategoryElement(CategoryElementDto categoryElementDto);

    List<CategoryElementDto> insertAndUpdateAllCategoryElement(List<CategoryElementDto> categoryElementDtoList);

    void deleteCategory(Long id);
}
