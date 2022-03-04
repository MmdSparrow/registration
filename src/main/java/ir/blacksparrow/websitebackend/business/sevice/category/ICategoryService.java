package ir.blacksparrow.websitebackend.business.sevice.category;

import ir.blacksparrow.websitebackend.business.dto.CategoryDto;

import java.util.List;

public interface ICategoryService {
    List<CategoryDto> getCategoryList();
    List<CategoryDto> searchCategory(CategoryDto categoryDto);
    CategoryDto getCategoryById(long id);

    CategoryDto insertAndUpdateCategory(CategoryDto categoryDto);


    void deleteCategory(Long id);
}
