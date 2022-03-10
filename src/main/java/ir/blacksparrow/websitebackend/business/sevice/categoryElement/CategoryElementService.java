package ir.blacksparrow.websitebackend.business.sevice.categoryElement;

import ir.blacksparrow.websitebackend.business.dto.CategoryElementDto;
import ir.blacksparrow.websitebackend.business.dto.CategoryElementDtoChildId;
import ir.blacksparrow.websitebackend.repository.category.CategoryRepository;
import ir.blacksparrow.websitebackend.repository.categoryElement.CategoryElementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryElementService implements ICategoryElementService {

    private final CategoryElementRepository categoryElementRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryElementDto> getCategoryElementList() {
        return categoryElementRepository.findAll();
    }

    @Override
    public List<CategoryElementDto> getCategoryElementList(int offset, int size) {
        return categoryElementRepository.findAll(offset, size);
    }

    @Override
    public List<CategoryElementDto> searchCategoryElement(CategoryElementDto categoryElementDto) {
        return categoryElementRepository.search(categoryElementDto.getCode(),categoryElementDto.getTitle(),categoryElementDto.getCategory().getId(),categoryElementDto.getCategory().getCode(), categoryElementDto.getCategory().getTitle());


    }

    @Override
    public List<CategoryElementDto> searchCategoryElement(CategoryElementDto categoryElementDto, int offset, int size) {
        return categoryElementRepository.search(categoryElementDto.getCode(),categoryElementDto.getTitle(),categoryElementDto.getCategory().getId(),categoryElementDto.getCategory().getCode(), categoryElementDto.getCategory().getTitle(), offset, size);
    }

    @Override
    public Optional<CategoryElementDto> getCategoryElementById(long id) {
        return categoryElementRepository.getById(id);
    }

    @Override
    public Optional<CategoryElementDto> insertAndUpdateCategoryElement(CategoryElementDtoChildId categoryElementDtoChildId) {
        CategoryElementDto categoryElementDto=new CategoryElementDto(categoryElementDtoChildId.getId(), categoryElementDtoChildId.getCode(), categoryElementDtoChildId.getTitle(), categoryRepository.getById(categoryElementDtoChildId.getCategoryId()).orElse(null));
        return categoryElementRepository.insertAndUpdate(categoryElementDto);
    }

    @Override
    public List<CategoryElementDto> insertAndUpdateAllCategoryElement(List<CategoryElementDtoChildId> categoryElementDtoChildIdList) {
        List<CategoryElementDto> categoryElementDtoList=new ArrayList<>();
        for(CategoryElementDtoChildId categoryElementDtoChildId: categoryElementDtoChildIdList){
            CategoryElementDto categoryElementDto=new CategoryElementDto(categoryElementDtoChildId.getId(), categoryElementDtoChildId.getCode(), categoryElementDtoChildId.getTitle(), categoryRepository.getById(categoryElementDtoChildId.getCategoryId()).orElse(null));
            categoryElementDtoList.add(categoryElementDto);
        }
        return categoryElementRepository.insertAndUpdateAll(categoryElementDtoList);
    }

    @Override
    public void deleteCategoryElement(Long id) {
        categoryElementRepository.delete(id);
    }
}
