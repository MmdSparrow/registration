package ir.blacksparrow.websitebackend.view.controller.categoryElement;

import ir.blacksparrow.websitebackend.business.dto.CategoryDto;
import ir.blacksparrow.websitebackend.business.dto.CategoryElementDto;
import ir.blacksparrow.websitebackend.business.dto.CategoryElementDtoChildId;
import ir.blacksparrow.websitebackend.business.dto.ResponseDto;
import ir.blacksparrow.websitebackend.business.sevice.categoryElement.ICategoryElementService;
import ir.blacksparrow.websitebackend.view.controller.ParentController;
import ir.blacksparrow.websitebackend.view.controller.categoryElement.validator.CategoryElementValidator;
import ir.blacksparrow.websitebackend.view.viewDto.category.viewDto.CategoryViewDto;
import ir.blacksparrow.websitebackend.view.viewDto.categoryElement.viewDto.CategoryElementViewDto;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Transactional
@RestController
@RequestMapping("/category-element")
public class CategoryElementController extends ParentController {

    private final ICategoryElementService categoryElementService;

    public CategoryElementController(ModelMapper modelMapper, ICategoryElementService categoryElementService) {
        super(modelMapper);
        this.categoryElementService = categoryElementService;
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ResponseDto> findAllCategoryElements(
            @RequestParam(value = "offset", required = false) Integer offset,
            @RequestParam(value = "size", required = false) Integer size
    ) {
        if (!CategoryElementValidator.isValidSizeOffset(size, offset))
            return sendResponse(new ResponseDto(false, "invalid size or offset", null), HttpStatus.BAD_REQUEST);
        if(size==null){
            try{
                List<CategoryElementDto> categoryElementDtoList = categoryElementService.getCategoryElementList();
                return sendResponse(new ResponseDto(true,null,categoryElementDtoList, categoryElementDtoList.size()), HttpStatus.OK);
            } catch (Exception e) {
                return sendResponse(new ResponseDto(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
            }
        }else {
            try{
                List<CategoryElementDto> categoryElementDtoList = categoryElementService.getCategoryElementList(offset, size);
                return sendResponse(new ResponseDto(true,null,categoryElementDtoList,categoryElementDtoList.size()), HttpStatus.OK);
            } catch (Exception e) {
                return sendResponse(new ResponseDto(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
            }
        }
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ResponseDto>  getCategoryById(
            @PathVariable Long id
    ) {
        try {
            Optional<CategoryElementDto> categoryElementDto = categoryElementService.getCategoryElementById(id);
            return sendResponse(new ResponseDto(true,null,categoryElementDto), HttpStatus.OK);
        } catch (Exception e) {
            return sendResponse(new ResponseDto(false,e.getMessage(),null),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(
            path = "/search",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ResponseDto> searchCategory(
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "CategoryId", required = false) Long categoryId,
            @RequestParam(value = "CategoryCode", required = false) String categoryCode,
            @RequestParam(value = "CategoryTitle", required = false) String categoryTitle,
            @RequestParam(value = "offset", required = false) Integer offset,
            @RequestParam(value = "size", required = false) Integer size
    ) {
        if(!CategoryElementValidator.isValidSizeOffset(size,offset))
            return sendResponse(new ResponseDto(false,"invalid size or offset",null), HttpStatus.BAD_REQUEST);

        if(size==null){
            try{
                CategoryDto categoryDto=new CategoryDto(categoryId, categoryCode, categoryTitle);
                CategoryElementDto categoryElementDto=new CategoryElementDto(code,title,categoryDto);
                List<CategoryElementDto> categoryElementDtoList = categoryElementService.searchCategoryElement(categoryElementDto);
                return sendResponse(new ResponseDto(true,null,categoryElementDtoList,categoryElementDtoList.size()), HttpStatus.OK);
            } catch (Exception e) {
                return sendResponse(new ResponseDto(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
            }
        }else {
            try{
                CategoryDto categoryDto=new CategoryDto(categoryId, categoryCode, categoryTitle);
                CategoryElementDto categoryElementDto=new CategoryElementDto(code,title,categoryDto);
                List<CategoryElementDto> categoryElementDtoList = categoryElementService.searchCategoryElement(categoryElementDto, offset, size);
                return sendResponse(new ResponseDto(true,null,categoryElementDtoList,categoryElementDtoList.size()), HttpStatus.OK);
            } catch (Exception e) {
                return sendResponse(new ResponseDto(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
            }
        }
    }


    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ResponseDto> addCategory(
            @RequestBody CategoryElementViewDto categoryElement
    ) {
        try {
            Optional<CategoryElementDto> categoryElementDto = categoryElementService.insertAndUpdateCategoryElement(getModelMapper().map(categoryElement, CategoryElementDtoChildId.class));
            return sendResponse(new ResponseDto(true, null, categoryElementDto), HttpStatus.OK);
        } catch (Exception e) {
            return sendResponse(new ResponseDto(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ResponseDto> editCategory(
            @RequestBody CategoryElementViewDto categoryElement,
            @PathVariable Long id
    ) {
        try {
            CategoryElementDtoChildId categoryElementDtoChildId = getModelMapper().map(categoryElement, CategoryElementDtoChildId.class);
            categoryElementDtoChildId.setId(id);
            CategoryElementDto categoryElementDto = categoryElementService.insertAndUpdateCategoryElement(categoryElementDtoChildId).orElse(null);
            return sendResponse(new ResponseDto(true,null, categoryElementDto), HttpStatus.OK);
        } catch (Exception e) {
            return sendResponse(new ResponseDto(false,e.getMessage(),null),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ResponseDto> deleteCategory(
            @PathVariable Long id
    ) {
        try {
            categoryElementService.deleteCategoryElement(id);
            return sendResponse(new ResponseDto(true,null,null), HttpStatus.OK);
        } catch (Exception e) {
            return sendResponse(new ResponseDto(false,e.getMessage(),null),HttpStatus.BAD_REQUEST);
        }
    }
}
