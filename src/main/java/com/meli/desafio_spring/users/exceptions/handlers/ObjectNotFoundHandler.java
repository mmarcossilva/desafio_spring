package com.meli.desafio_spring.users.exceptions.handlers;

import com.meli.desafio_spring.users.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ObjectNotFoundHandler {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<?> handleItemNotFound(ObjectNotFoundException exception){
        return ResponseEntity.badRequest().build();
    }
}
