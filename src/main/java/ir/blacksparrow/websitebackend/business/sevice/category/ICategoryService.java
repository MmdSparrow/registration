package ir.blacksparrow.websitebackend.business.sevice.category;

import ir.blacksparrow.websitebackend.business.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<CategoryDto> getCategoryList();
    List<CategoryDto> getCategoryList(int offset, int size);
    List<CategoryDto> searchCategory(CategoryDto categoryDto);
    List<CategoryDto> searchCategory(CategoryDto categoryDto, int offset, int size);
    Optional<CategoryDto> getCategoryById(long id);
    Optional<CategoryDto> insertAndUpdateCategory(CategoryDto categoryDto);
    void deleteCategory(Long id);
}
