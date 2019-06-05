package com.gmail.erofeev.st.alexei.controlwork.service;

import com.gmail.erofeev.st.alexei.controlwork.service.model.UserDTO;

public interface UserService {
    UserDTO findUserByName(String name);
}
