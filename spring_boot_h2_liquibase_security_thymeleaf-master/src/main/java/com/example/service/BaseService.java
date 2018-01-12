package com.example.service;

public interface BaseService<T, ID> {

    Iterable<?> findAll();

    T findOne(ID id);

    T saveOrUpdate(T object);

    void delete(ID id);
}
