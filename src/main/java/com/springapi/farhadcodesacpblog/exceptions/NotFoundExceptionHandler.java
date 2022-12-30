package com.springapi.farhadcodesacpblog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotFoundExceptionHandler extends ResponseEntityExceptionHandler implements RestExceptionHandler<NotFoundException> {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handle(NotFoundException ex) {

        List<String> Error=new ArrayList<>();
        Error.add(ex.getMessage());
        ErrorBody errorBody = new ErrorBody();
        errorBody.setMessage(Error);
        errorBody.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorBody,HttpStatus.NOT_FOUND);
    }
}
