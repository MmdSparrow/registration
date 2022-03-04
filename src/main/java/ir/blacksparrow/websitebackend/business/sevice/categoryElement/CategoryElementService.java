package ir.blacksparrow.websitebackend.business.sevice.categoryElement;

import ir.blacksparrow.websitebackend.business.dto.CategoryElementDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryElementService implements ICategoryElementService{

    @Override
    public List<CategoryElementDto> getCategoryElementList() {
        return null;
    }

    @Override
    public List<CategoryElementDto> searchCategoryElement(String code, String title, Long categoryId, String categoryCode) {
        return null;
    }

    @Override
    public CategoryElementDto getCategoryElementById(long id) {
        return null;
    }

    @Override
    public CategoryElementDto insertCategoryElement(CategoryElementDto categoryElementDto) {
        return null;
    }

    @Override
    public CategoryElementDto updateCategoryElement(CategoryElementDto categoryElementDto) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
