package ir.blacksparrow.websitebackend.view.controller.category;

import ir.blacksparrow.websitebackend.business.dto.CategoryDto;
import ir.blacksparrow.websitebackend.business.dto.ResponseDto;
import ir.blacksparrow.websitebackend.business.sevice.category.CategoryService;
import ir.blacksparrow.websitebackend.business.sevice.category.ICategoryService;
import ir.blacksparrow.websitebackend.view.controller.ParentController;
import ir.blacksparrow.websitebackend.view.controller.category.validator.CategoryValidator;
import ir.blacksparrow.websitebackend.view.viewDto.category.viewDto.CategoryViewDtoIdChild;
import ir.blacksparrow.websitebackend.view.viewDto.category.viewDto.CategoryViewDtoObjectChild;
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
            @RequestParam(value = "offset", required = false) String offset,
            @RequestParam(value = "size", required = false) String size
    ) {
        if (!CategoryValidator.isValidSizeOffset(size, offset))
            return sendResponse(new ResponseDto(false, "invalid size or offset", null), HttpStatus.BAD_REQUEST);
        try {
            List<CategoryDto> categoryDtoList = categoryService.getCategoryList();
            return sendResponse(new ResponseDto(
                    true,
                    null,
                    (size != null) ? categoryDtoList.subList(
                            Integer.parseInt(offset) - 1,
                            this.getSize(Integer.parseInt(size), Integer.parseInt(offset) - 1, categoryDtoList.size())
                    ) : categoryDtoList,
                    categoryDtoList.size()
            ), HttpStatus.OK);
        } catch (Exception e) {
            return sendResponse(new ResponseDto(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }

    }

//    @GetMapping(
//            path = "/search",
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public List<CategoryDto> searchCategory(
//            @RequestParam(value = "code", required = false)String code,
//            @RequestParam(value = "title", required = false)String title,
//            @RequestParam(value = "offset", required = false) String offset,
//            @RequestParam(value = "size", required = false) String size
//    ) {
//        if(!CategoryValidator.isValidSizeOffset(size,offset))
//            return sendResponse(new ResponseDto(false,"invalid size or offset",null), HttpStatus.BAD_REQUEST);
//
//        try {
//            List<CategoryDto> categoryDtoList = categoryService.searchCategory(code,title);
//            int newSize = this.getSize(Integer.parseInt(size),Integer.parseInt(offset)-1,categoryDtoList.size());
//            return sendResponse(new ResponseDto(
//                    true,
//                    null,
//                    categoryDtoList.subList(Integer.parseInt(offset)-1, newSize),
//                    categoryDtoList.size()
//            ), HttpStatus.OK);
//        } catch (Exception e) {
//            return sendResponse(new ResponseDto(false,e.getMessage(),null),HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping(
//            path = "/{id}",
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public CategoryDto  getCategoryById(
//            @PathVariable String id
//    ) {
//        try {
//            CategoryDto categoryDto = categoryService.getCategoryById(Long.parseLong(id));
//            return sendResponse(new ResponseDto(true,null,categoryDto), HttpStatus.OK);
//        } catch (Exception e) {
//            return sendResponse(new ResponseDto(false,e.getMessage(),null),HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ResponseDto> addCategory(
            @RequestBody CategoryViewDtoObjectChild category
    ) {
        try {
            Optional<CategoryDto> categoryDto = categoryService.insertAndUpdateCategory(getMapper().map(category, CategoryDto.class));
            return sendResponse(new ResponseDto(true, null, categoryDto), HttpStatus.OK);
        } catch (Exception e) {
            return sendResponse(new ResponseDto(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

//    @PutMapping(
//            path = "/{id}",
//            produces = MediaType.APPLICATION_JSON_VALUE,
//            consumes = MediaType.APPLICATION_JSON_VALUE
//    )
//    public CategoryDto editCategory(
//            @RequestHeader("Authorization") String token,
//            @RequestBody CategoryViewDto category,
//            @PathVariable String id
//    ) {
//        try {
//            CategoryDto categoryDto = mapper.map(category, CategoryDto.class);
//            categoryDto.setId(Long.parseLong(id));
//            categoryDto = categoryService.updateCategory(categoryDto);
//            return sendResponse(new ResponseDto(true,null,categoryDto), HttpStatus.OK);
//        } catch (Exception e) {
//            return sendResponse(new ResponseDto(false,e.getMessage(),null),HttpStatus.BAD_REQUEST);
//        }
//    }

//    @DeleteMapping(
//            path = "/{id}",
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public CategoryDto deleteCategory(
//            @PathVariable String id
//    ) {
//        try {
//            categoryService.deleteCategory(Long.parseLong(id));
//            return sendResponse(new ResponseDto(true,null,null), HttpStatus.OK);
//        } catch (Exception e) {
//            return sendResponse(new ResponseDto(false,e.getMessage(),null),HttpStatus.BAD_REQUEST);
//        }
//    }
}
