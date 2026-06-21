package com.example.auth.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserInputExceptionHandler {

    @ExceptionHandler(InvalidUserInputException.class)
    public ResponseEntity<?> handleInvalidUserInputException(InvalidUserInputException ex) {
        Map<String, String> errors = Map.of("error", ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); 
    }

}
