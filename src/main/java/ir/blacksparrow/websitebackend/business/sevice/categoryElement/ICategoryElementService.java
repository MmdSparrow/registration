package ir.blacksparrow.websitebackend.business.sevice.categoryElement;

import ir.blacksparrow.websitebackend.business.dto.CategoryElementDto;

import java.util.List;
import java.util.Optional;

public interface ICategoryElementService {
    List<CategoryElementDto> getCategoryElementList();
    List<CategoryElementDto> getCategoryElementList(int offset, int size);
    List<CategoryElementDto> searchCategoryElement(String code,String title,Long categoryId,String categoryCode);
    Optional<CategoryElementDto> getCategoryElementById(long id);

    Optional<CategoryElementDto> insertAndUpdateCategoryElement(CategoryElementDto categoryElementDto);

    List<CategoryElementDto> insertAndUpdateAllCategoryElement(List<CategoryElementDto> categoryElementDtoList);

    void deleteCategory(Long id);
}
