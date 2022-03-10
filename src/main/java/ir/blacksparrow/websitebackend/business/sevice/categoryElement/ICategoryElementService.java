package ir.blacksparrow.websitebackend.business.sevice.categoryElement;

import ir.blacksparrow.websitebackend.business.dto.CategoryElementDto;
import ir.blacksparrow.websitebackend.business.dto.CategoryElementDtoChildId;

import java.util.List;
import java.util.Optional;

public interface ICategoryElementService {
    List<CategoryElementDto> getCategoryElementList();
    List<CategoryElementDto> getCategoryElementList(int offset, int size);
    List<CategoryElementDto> searchCategoryElement(CategoryElementDto categoryElementDto);
    List<CategoryElementDto> searchCategoryElement(CategoryElementDto categoryElementDto, int offset, int size);
    Optional<CategoryElementDto> getCategoryElementById(long id);

    Optional<CategoryElementDto> insertAndUpdateCategoryElement(CategoryElementDtoChildId categoryElementDtoChildId);

    List<CategoryElementDto> insertAndUpdateAllCategoryElement(List<CategoryElementDtoChildId> categoryElementDtoChildIdList);

    void deleteCategoryElement(Long id);
}
