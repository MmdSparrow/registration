package ir.blacksparrow.websitebackend.business.sevice.category;

import ir.blacksparrow.websitebackend.business.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<CategoryDto> getCategoryList();
    List<CategoryDto> searchCategory(CategoryDto categoryDto);
    Optional<CategoryDto> getCategoryById(long id);
    Optional<CategoryDto> insertAndUpdateCategory(CategoryDto categoryDto);
    void deleteCategory(Long id);
}
