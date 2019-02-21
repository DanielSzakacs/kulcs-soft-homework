package com.daniel.szakacs.kulcssofthomework.service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityManger {

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    public String hashingCode(String password){
        return passwordEncoder().encode(password);
    }

    @Bean
    public boolean matchPasswords(String password, String hashedPassword){
        return passwordEncoder().matches(password, hashedPassword);
    }
}
