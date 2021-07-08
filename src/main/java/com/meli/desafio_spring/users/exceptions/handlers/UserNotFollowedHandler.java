package com.meli.desafio_spring.users.exceptions.handlers;

import com.meli.desafio_spring.users.exceptions.UserNotFollowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserNotFollowedHandler {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFollowed.class)
    public ResponseEntity<?> handleUserNotFollowed(UserNotFollowed exception){
        return ResponseEntity.badRequest().build();
    }
}
