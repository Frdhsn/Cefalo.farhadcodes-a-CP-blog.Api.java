package com.springapi.farhadcodesacpblog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Component
public class UnauthorizedExceptionHandler extends ResponseEntityExceptionHandler implements RestExceptionHandler<UnauthorizedException> {
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Object> handle(UnauthorizedException ex) {

        List<String> Error=new ArrayList<>();
        Error.add(ex.getMessage());
        ErrorBody errorBody = new ErrorBody();
        errorBody.setMessage(Error);
        errorBody.setStatus(HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(errorBody, HttpStatus.UNAUTHORIZED);
    }
}
