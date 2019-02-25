package com.daniel.szakacs.kulcssofthomework.service.login;

import com.daniel.szakacs.kulcssofthomework.service.module.Admin;
import com.daniel.szakacs.kulcssofthomework.DAO.repository.AdminRepo;
import com.daniel.szakacs.kulcssofthomework.service.security.SecurityManger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Login {

    @Autowired
    private SecurityManger securityManger;

    // TODO ez a fő method
    public boolean isUserEmailAndPasswordCorrect(String email, String password, AdminRepo userRepository) {
        if(userRepository.existsByEmail(email)){
            return isPasswordCorrect(email, password, userRepository);
        }else{
            return false;
        }
    }

    private boolean isPasswordCorrect(String email, String inputPassword, AdminRepo userRepository){
        Admin admin = userRepository.getByEmail(email);
        return new BCryptPasswordEncoder().matches(inputPassword, admin.getPassword()); // TODO this is should be in a lover level in the Security class.
    }


}
