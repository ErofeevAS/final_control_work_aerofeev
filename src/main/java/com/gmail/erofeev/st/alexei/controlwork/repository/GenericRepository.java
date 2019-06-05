package com.gmail.erofeev.st.alexei.controlwork.repository;

import java.util.List;

public interface GenericRepository<I, T> {

    void persist(T entity);

    void remove(T entity);

    T findById(I id);

    List<T> findAll();
}