package com.gmail.erofeev.st.alexei.controlwork.service.impl;

import com.gmail.erofeev.st.alexei.controlwork.service.UserService;
import com.gmail.erofeev.st.alexei.controlwork.service.model.AppUserPrincipal;
import com.gmail.erofeev.st.alexei.controlwork.service.model.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = userService.findUserByName(username);
        if (user == null) {
            String message = "User is not found: " + username;
            logger.error(message);
            throw new UsernameNotFoundException(message);
        }
        return new AppUserPrincipal(user);
    }
}