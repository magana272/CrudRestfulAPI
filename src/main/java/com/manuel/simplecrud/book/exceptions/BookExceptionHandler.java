package com.manuel.simplecrud.book.exceptions;


import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BookExceptionHandler {


    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<Map<String, String>> handleVadlidationError(PropertyValueException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put("Error", "Bad Request");
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ex.getMessage(); // Or return a custom error object/JSON
    }
}
