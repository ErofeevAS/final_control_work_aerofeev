package com.gmail.erofeev.st.alexei.controlwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.gmail.erofeev.st.alexei.controlwork", exclude = UserDetailsServiceAutoConfiguration.class)
@EntityScan("com.gmail.erofeev.st.alexei.controlwork.repository.model")
public class SpringBootSecureApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecureApplication.class, args);
    }
}
