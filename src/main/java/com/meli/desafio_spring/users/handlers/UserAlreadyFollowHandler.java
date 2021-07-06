package com.meli.desafio_spring.users.handlers;

import com.meli.desafio_spring.users.exceptions.ObjectNotFoundException;
import com.meli.desafio_spring.users.exceptions.UserAlreadyFollow;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserAlreadyFollowHandler {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAlreadyFollow.class)
    public ResponseEntity<?> hadleItemNotFound(UserAlreadyFollow exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
