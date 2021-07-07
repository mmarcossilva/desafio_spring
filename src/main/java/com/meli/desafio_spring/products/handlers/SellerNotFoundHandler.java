package com.meli.desafio_spring.products.handlers;

import com.meli.desafio_spring.products.exceptions.ObjectIdAlreadyExistsExeception;
import com.meli.desafio_spring.products.exceptions.SellerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SellerNotFoundHandler {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SellerNotFoundException.class)
    public ResponseEntity<?> handleSellerNotFound(SellerNotFoundException exception){
        return ResponseEntity.badRequest().build();
    }
}
