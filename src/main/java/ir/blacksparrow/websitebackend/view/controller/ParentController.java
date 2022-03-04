package ir.blacksparrow.websitebackend.view.controller;

import ir.blacksparrow.websitebackend.business.dto.ResponseDto;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Data
//@Component
public class ParentController {
    private final ModelMapper mapper = new ModelMapper();

    protected int getSize(int size,int offset,int length){
        if(offset+size < length )
            return offset+size;
        else if(offset + 1 > length)
            return 0;
        else
            return length - offset ;
    }

    protected ResponseEntity<ResponseDto> sendResponse(ResponseDto responseDto, HttpStatus httpStatus){
        return new ResponseEntity<>(responseDto, httpStatus);
    }
}
