package com.daniel.szakacs.kulcssofthomework.service.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Secutiry {

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public String hashingCode(String password){
        return this.passwordEncoder().encode(password);
    }

    public boolean matchPasswords(String password, String hashedPassword){
        return this.passwordEncoder().matches(password, hashedPassword);
    }
}
