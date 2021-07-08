package com.meli.desafio_spring.products.exceptions.handlers;

import com.meli.desafio_spring.products.exceptions.ObjectIdAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ObjectIdAlreadyExistsHandler {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ObjectIdAlreadyExistsException.class)
    public ResponseEntity<?> handleObjectIdAlreadyExists(ObjectIdAlreadyExistsException exception){
        return ResponseEntity.badRequest().build();
    }
}
