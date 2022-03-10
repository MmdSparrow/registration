package ir.blacksparrow.websitebackend.business.sevice.categoryElement;

import ir.blacksparrow.websitebackend.business.dto.CategoryElementDto;
import ir.blacksparrow.websitebackend.repository.categoryElement.CategoryElementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryElementService implements ICategoryElementService {

    private final CategoryElementRepository categoryElementRepository;

    @Override
    public List<CategoryElementDto> getCategoryElementList() {
        return categoryElementRepository.findAll();
    }

    @Override
    public List<CategoryElementDto> getCategoryElementList(int offset, int size) {
        return categoryElementRepository.findAll(offset, size);
    }

    @Override
    public List<CategoryElementDto> searchCategoryElement(String code, String title, Long categoryId, String categoryCode) {
        return null;
    }

    @Override
    public Optional<CategoryElementDto> getCategoryElementById(long id) {
        return categoryElementRepository.getById(id);
    }

    @Override
    public Optional<CategoryElementDto> insertAndUpdateCategoryElement(CategoryElementDto categoryElementDto) {
        return categoryElementRepository.insertAndUpdate(categoryElementDto);
    }

    @Override
    public List<CategoryElementDto> insertAndUpdateAllCategoryElement(List<CategoryElementDto> categoryElementDtoList) {
        return categoryElementRepository.insertAndUpdateAll(categoryElementDtoList);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryElementRepository.delete(id);
    }
}
