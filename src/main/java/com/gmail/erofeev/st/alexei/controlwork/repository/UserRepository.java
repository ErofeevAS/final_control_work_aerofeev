package com.gmail.erofeev.st.alexei.controlwork.repository;


import com.gmail.erofeev.st.alexei.controlwork.repository.model.User;

public interface UserRepository extends GenericRepository<Long, User> {
    User findByName(String name);
}
