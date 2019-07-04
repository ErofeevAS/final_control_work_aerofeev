package com.gmail.erofeev.st.alexei.controlwork.config.rest;

import com.gmail.erofeev.st.alexei.controlwork.config.rest.handler.ApiAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import static com.gmail.erofeev.st.alexei.controlwork.config.GlobalConstant.ADMIN;
import static com.gmail.erofeev.st.alexei.controlwork.config.GlobalConstant.CUSTOMER;
import static com.gmail.erofeev.st.alexei.controlwork.config.GlobalConstant.PASSWORD_BCRYPT_ROUNDS;
import static com.gmail.erofeev.st.alexei.controlwork.config.GlobalConstant.PRIVATE_URL;
import static com.gmail.erofeev.st.alexei.controlwork.config.GlobalConstant.PUBLIC_URL;

@Configuration
@Order
public class RestApiSecurityConfigurer extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    @Autowired
    public RestApiSecurityConfigurer(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(PRIVATE_URL)
                .hasAuthority(ADMIN)
                .antMatchers(PUBLIC_URL)
                .hasAuthority(CUSTOMER)
                .and()
                .httpBasic()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(apiAccessDeniedHandler())
                .and()
                .csrf()
                .disable();
    }

    @Bean
    public AccessDeniedHandler apiAccessDeniedHandler() {
        return new ApiAccessDeniedHandler();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(PASSWORD_BCRYPT_ROUNDS);
    }
}