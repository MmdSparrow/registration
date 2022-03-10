package ir.blacksparrow.websitebackend.repository.categoryElement;

import ir.blacksparrow.websitebackend.business.dto.CategoryDto;
import ir.blacksparrow.websitebackend.business.dto.CategoryElementDto;
import ir.blacksparrow.websitebackend.dataModel.CategoryElementEntity;
import ir.blacksparrow.websitebackend.dataModel.CategoryEntity;
import ir.blacksparrow.websitebackend.repository.ParentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryElementRepository extends ParentRepository {
    private final ICategoryElementRepository categoryElementRepository;


    public CategoryElementRepository(ModelMapper modelMapper, ICategoryElementRepository categoryElementRepository) {
        super(modelMapper);
        this.categoryElementRepository = categoryElementRepository;

        TypeMap<CategoryElementDto, CategoryElementEntity> propertyMapper = modelMapper.createTypeMap(CategoryElementDto.class, CategoryElementEntity.class);
        propertyMapper.addMappings(
                mapper -> mapper.map(CategoryElementDto::getCategory, CategoryElementEntity::setCategoryEntity)
        );
    }

    public List<CategoryElementDto> findAll() {
        List<CategoryElementEntity> categoryElementEntityList = categoryElementRepository.findAll();
        return mapList(categoryElementEntityList, CategoryElementDto.class);
    }

    public List<CategoryElementDto> findAll(int offset, int size) {
        List<CategoryElementEntity> categoryElementEntityList = categoryElementRepository.findAll(offset, size);
        return mapList(categoryElementEntityList, CategoryElementDto.class);
    }

    public Optional<CategoryElementDto> getById(Long id) {
        try {
            CategoryElementEntity categoryElementEntity = categoryElementRepository.getById(id);
            return Optional.of(getModelMapper().map(categoryElementEntity, CategoryElementDto.class));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<CategoryElementDto> search(String code, String title, long categoryId, String categoryCode, String categoryTitle) {
        List<CategoryElementEntity> categoryElementEntityList;
        if(categoryCode==null){
            categoryElementEntityList = categoryElementRepository.search(code, title, categoryId);
        }else {
            categoryElementEntityList = categoryElementRepository.search(code, title, categoryId, categoryCode, categoryTitle);
        }
        return mapList(categoryElementEntityList, CategoryElementDto.class);
    }


    public List<CategoryElementDto> search(String code, String title, long categoryId, String categoryCode, String categoryTitle, int offset, int size) {
        List<CategoryElementEntity> categoryElementEntityList;
        if(categoryCode==null){
            categoryElementEntityList = categoryElementRepository.search(code, title, categoryId, offset, size);
        }else {
            categoryElementEntityList = categoryElementRepository.search(code, title, categoryId, categoryCode, categoryTitle, offset, size);
        }
        return mapList(categoryElementEntityList, CategoryElementDto.class);
    }

    public Optional<CategoryElementDto> insertAndUpdate(CategoryElementDto categoryElementDto) {
        CategoryElementEntity categoryElementEntity = getModelMapper().map(categoryElementDto, CategoryElementEntity.class);
        categoryElementEntity = categoryElementRepository.save(categoryElementEntity);
        return Optional.of(getModelMapper().map(categoryElementEntity, CategoryElementDto.class));
    }

    public List<CategoryElementDto> insertAndUpdateAll(List<CategoryElementDto> categoryElementDtoList) {
        List<CategoryElementEntity> categoryElementEntityList = mapList(categoryElementDtoList, CategoryElementEntity.class);
        categoryElementEntityList = categoryElementRepository.saveAll(categoryElementEntityList);
        return mapList(categoryElementEntityList, CategoryElementDto.class);
    }

    public void delete(Long id) {
        categoryElementRepository.deleteById(id);
    }

}
