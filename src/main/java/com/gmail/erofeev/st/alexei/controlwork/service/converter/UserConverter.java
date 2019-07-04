package com.gmail.erofeev.st.alexei.controlwork.service.converter;

import com.gmail.erofeev.st.alexei.controlwork.repository.model.User;
import com.gmail.erofeev.st.alexei.controlwork.service.model.UserDTO;

public interface UserConverter {
    UserDTO toDTO(User user);
}
