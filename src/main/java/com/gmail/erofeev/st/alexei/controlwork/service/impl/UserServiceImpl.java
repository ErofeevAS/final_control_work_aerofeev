package com.gmail.erofeev.st.alexei.controlwork.service.impl;

import com.gmail.erofeev.st.alexei.controlwork.repository.UserRepository;
import com.gmail.erofeev.st.alexei.controlwork.repository.model.User;
import com.gmail.erofeev.st.alexei.controlwork.service.model.UserDTO;
import com.gmail.erofeev.st.alexei.controlwork.service.UserService;
import com.gmail.erofeev.st.alexei.controlwork.service.converter.UserConverter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    @Transactional
    public UserDTO findUserByName(String name) {
        User user = userRepository.findByName(name);
        return userConverter.toDTO(user);
    }
}
