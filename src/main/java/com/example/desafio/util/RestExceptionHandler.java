package com.example.desafio.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultApiErrorHelper> handle(Exception ex, HttpServletRequest request,
            HttpServletResponse response) {
        DefaultApiErrorHelper error = new DefaultApiErrorHelper(ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString());
        if (ex instanceof NullPointerException) {
            error.setMessage("BAD REQUEST.");
            return new ResponseEntity<DefaultApiErrorHelper>(error, HttpStatus.BAD_REQUEST);
        }
        if (ex instanceof CustomNotFoundException) {
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DefaultApiErrorHelper>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
