package com.uc.supplymgmtapi.service;

import java.util.List;

public interface GenericService<T> {
    T save(T t);

    T findById(String id);

    List<T> findAll();

    void deleteById(String id);
}
