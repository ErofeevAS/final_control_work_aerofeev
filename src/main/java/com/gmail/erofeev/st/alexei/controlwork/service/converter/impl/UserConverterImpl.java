package com.gmail.erofeev.st.alexei.controlwork.service.converter.impl;

import com.gmail.erofeev.st.alexei.controlwork.repository.model.User;
import com.gmail.erofeev.st.alexei.controlwork.service.converter.UserConverter;
import com.gmail.erofeev.st.alexei.controlwork.service.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {
    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setDeleted(user.getDeleted());
        return userDTO;
    }
}
