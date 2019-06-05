package com.gmail.erofeev.st.alexei.controlwork.repository.impl;

import com.gmail.erofeev.st.alexei.controlwork.repository.GenericRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericRepositoryImpl<I, T> implements GenericRepository<I, T> {
    protected Class<T> entityClass;
    @PersistenceContext
    protected EntityManager entityManager;

    public GenericRepositoryImpl() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[1];
    }

    @Override
    public void persist(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void remove(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public T findById(I id) {
        T entity = entityManager.find(entityClass, id);
        if (entity == null) {
            throw new EntityNotFoundException(entityClass.getSimpleName() + " with id:" + id + " not found");
        }
        return entity;
    }

    @Override
    public List<T> findAll() {
        String hql = "from " + entityClass.getName();
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }
}
