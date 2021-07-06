package com.meli.desafio_spring.users.repository.imple;

public interface DatabaseMethods<T> {
    T findById(Long id);
    void save(T item);
}
