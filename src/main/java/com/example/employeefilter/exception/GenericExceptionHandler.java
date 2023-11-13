package com.example.employeefilter.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(WrongUserNameOrPasswordException.class)
    public ResponseEntity handleWrongUserNameOrPassword(WrongUserNameOrPasswordException wrongUserNameOrPasswordException){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(wrongUserNameOrPasswordException.getMessage())
                .code(401)
                .success(Boolean.FALSE)
                .build();
        return  ResponseEntity.status(401).body(errorResponse);
    }
}