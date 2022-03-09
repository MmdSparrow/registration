package ir.blacksparrow.websitebackend.view.controller.category;

import ir.blacksparrow.websitebackend.business.dto.CategoryDto;
import ir.blacksparrow.websitebackend.business.dto.ResponseDto;
import ir.blacksparrow.websitebackend.business.sevice.category.CategoryService;
import ir.blacksparrow.websitebackend.business.sevice.category.ICategoryService;
import ir.blacksparrow.websitebackend.view.controller.ParentController;
import ir.blacksparrow.websitebackend.view.controller.category.validator.CategoryValidator;
import ir.blacksparrow.websitebackend.view.viewDto.category.viewDto.CategoryViewDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController extends ParentController {

    private final ICategoryService categoryService;

    public CategoryController(CategoryService category) {
        this.categoryService = category;
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ResponseDto> findAllCategories(
            @RequestParam(value = "offset", required = false) Integer offset,
            @RequestParam(value = "size", required = false) Integer size
    ) {
        if (!CategoryValidator.isValidSizeOffset(size, offset))
            return sendResponse(new ResponseDto(false, "invalid size or offset", null), HttpStatus.BAD_REQUEST);
        if(size==null){
            try{
                List<CategoryDto> categoryDtoList = categoryService.getCategoryList();
                return sendResponse(new ResponseDto(true,null,categoryDtoList,categoryDtoList.size()), HttpStatus.OK);
            } catch (Exception e) {
                return sendResponse(new ResponseDto(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
            }
        }else {
            try{
                List<CategoryDto> categoryDtoList = categoryService.getCategoryList(offset, size);
                return sendResponse(new ResponseDto(true,null,categoryDtoList,categoryDtoList.size()), HttpStatus.OK);
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
            Optional<CategoryDto> categoryDto = categoryService.getCategoryById(id);
            return sendResponse(new ResponseDto(true,null,categoryDto), HttpStatus.OK);
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
            @RequestParam(value = "offset", required = false) Integer offset,
            @RequestParam(value = "size", required = false) Integer size
    ) {
        if(!CategoryValidator.isValidSizeOffset(size,offset))
            return sendResponse(new ResponseDto(false,"invalid size or offset",null), HttpStatus.BAD_REQUEST);

        if(size==null){
            try{
                List<CategoryDto> categoryDtoList = categoryService.searchCategory(new CategoryDto(code,title));
                return sendResponse(new ResponseDto(true,null,categoryDtoList,categoryDtoList.size()), HttpStatus.OK);
            } catch (Exception e) {
                return sendResponse(new ResponseDto(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
            }
        }else {
            try{
                List<CategoryDto> categoryDtoList = categoryService.searchCategory(new CategoryDto(code,title), offset, size);
                return sendResponse(new ResponseDto(true,null,categoryDtoList,categoryDtoList.size()), HttpStatus.OK);
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
            @RequestBody CategoryViewDto category
    ) {
        try {
            Optional<CategoryDto> categoryDto = categoryService.insertAndUpdateCategory(getMapper().map(category, CategoryDto.class));
            return sendResponse(new ResponseDto(true, null, categoryDto), HttpStatus.OK);
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
            @RequestBody CategoryViewDto category,
            @PathVariable Long id
    ) {
        try {
            CategoryDto categoryDto = getMapper().map(category, CategoryDto.class);
            categoryDto.setId(id);
            categoryDto = categoryService.insertAndUpdateCategory(categoryDto).orElse(null);
            return sendResponse(new ResponseDto(true,null, categoryDto), HttpStatus.OK);
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
            categoryService.deleteCategory(id);
            return sendResponse(new ResponseDto(true,null,null), HttpStatus.OK);
        } catch (Exception e) {
            return sendResponse(new ResponseDto(false,e.getMessage(),null),HttpStatus.BAD_REQUEST);
        }
    }
}
