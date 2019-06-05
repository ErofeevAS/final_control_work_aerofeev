package com.gmail.erofeev.st.alexei.controlwork.config;

import com.gmail.erofeev.st.alexei.controlwork.repository.model.enums.RoleEnum;

public class GlobalConstant {
    public static final String ADMIN = RoleEnum.ADMINISTRATOR.name();
    public static final String CUSTOMER = RoleEnum.CUSTOMER.name();
    public static final int PASSWORD_BCRYPT_ROUNDS = 10;
    public static final String SUCCESS_MESSAGE = "OPERATION COMPLETED SUCCESSFUL";
    public static final String PRIVATE_URL = "/api/v1/private/**";
    public static final String PUBLIC_URL = "/api/v1/public/**";
}
