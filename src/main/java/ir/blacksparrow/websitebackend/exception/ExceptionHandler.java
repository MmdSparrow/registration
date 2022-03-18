package ir.blacksparrow.websitebackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleRequestException(CustomException e){
        ExceptionTemplate exceptionTemplate = new ExceptionTemplate(
                HttpStatus.BAD_REQUEST,
                e.getMessage()
        );
        return new ResponseEntity<>(exceptionTemplate, exceptionTemplate.httpStatus());
    }
}
