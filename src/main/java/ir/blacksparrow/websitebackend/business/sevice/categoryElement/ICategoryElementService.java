package ir.blacksparrow.websitebackend.business.sevice.categoryElement;

import ir.blacksparrow.websitebackend.business.dto.CategoryElementDto;

import java.util.List;

public interface ICategoryElementService {
    List<CategoryElementDto> getCategoryElementList();
    List<CategoryElementDto> searchCategoryElement(String code,String title,Long categoryId,String categoryCode);
    CategoryElementDto getCategoryElementById(long id);

    CategoryElementDto insertCategoryElement(CategoryElementDto categoryElementDto);

    CategoryElementDto updateCategoryElement(CategoryElementDto categoryElementDto);

    void deleteCategory(Long id);
}
