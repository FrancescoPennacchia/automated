package com.example.automated;

import com.example.automated.controller.BiographyController;
import com.example.automated.controller.UserController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Beans {
    @Bean
    public UserController getUserController() {
        return new UserController();
    }

    @Bean
    public BiographyController getBiographyController() {
        return new BiographyController();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
