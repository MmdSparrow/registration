package ir.blacksparrow.websitebackend.repository.categoryElement;

import ir.blacksparrow.websitebackend.business.dto.CategoryElementDto;
import ir.blacksparrow.websitebackend.dataModel.CategoryElementEntity;
import ir.blacksparrow.websitebackend.repository.ParentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Repository
public class CategoryElementRepository extends ParentRepository {
    private final ICategoryElementRepository categoryElementRepository;

    public CategoryElementRepository(ICategoryElementRepository categoryElementRepository) {
        this.categoryElementRepository = categoryElementRepository;
    }

    public List<CategoryElementDto> findAll(){
        List<CategoryElementEntity> categoryElementEntityList = categoryElementRepository.findAll();
        return mapList(categoryElementEntityList, CategoryElementDto.class);
    }

    public CategoryElementDto getById(Long id){
        try{
            CategoryElementEntity  categoryElementEntity = categoryElementRepository.getById(id);
            return getModelMapper().map(categoryElementEntity, CategoryElementDto.class);
        }catch (Exception e) {
            return null;
        }
    }

    public CategoryElementDto insert(CategoryElementDto categoryElementDto){
        CategoryElementEntity categoryElementEntity = getModelMapper().map(categoryElementDto,CategoryElementEntity.class);
        categoryElementEntity = categoryElementRepository.save(categoryElementEntity);
        return getModelMapper().map(categoryElementEntity,CategoryElementDto.class);
    }

    public CategoryElementDto update(CategoryElementDto categoryElementDto){
        CategoryElementEntity categoryElementEntity = getModelMapper().map(categoryElementDto,CategoryElementEntity.class);
        categoryElementEntity = categoryElementRepository.save(categoryElementEntity);
        return getModelMapper().map(categoryElementEntity,CategoryElementDto.class);
    }

//
//    public List<CategoryElementDto> search(CategoryElementDto categoryElementDto){
//
//    }

    public void delete(Long id){
        categoryElementRepository.deleteById(id);
    }

}
