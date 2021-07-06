package com.meli.desafio_spring.users.exceptions;

public class UserAlreadyFollow extends RuntimeException {
    public UserAlreadyFollow() {
        super("This user already follows this seller");
    }
}
