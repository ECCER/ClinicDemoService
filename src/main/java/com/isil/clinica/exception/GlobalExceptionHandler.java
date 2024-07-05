package com.isil.clinica.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex){
        List<String> details = ex.getBindingResult()
            .getAllErrors()
            .stream()
            .map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
            .collect(Collectors.toList());

            ErrorResponse errorResponse = new ErrorResponse("Validation Failed", details);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
