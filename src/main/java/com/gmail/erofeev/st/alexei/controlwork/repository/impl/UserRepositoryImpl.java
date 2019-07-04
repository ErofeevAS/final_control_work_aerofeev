package com.gmail.erofeev.st.alexei.controlwork.repository.impl;

import com.gmail.erofeev.st.alexei.controlwork.repository.UserRepository;
import com.gmail.erofeev.st.alexei.controlwork.repository.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<Long, User> implements UserRepository {

    @Override
    public User findByName(String name) {
        String hql = "select u from User u where u.name = :name";
        Query query = entityManager.createQuery(hql, User.class);
        query.setParameter("name", name);
        return (User) query.getSingleResult();
    }
}
