package com.daniel.szakacs.kulcssofthomework.service.login;

import com.daniel.szakacs.kulcssofthomework.service.module.User;
import com.daniel.szakacs.kulcssofthomework.DAO.repository.Userrepository;
import com.daniel.szakacs.kulcssofthomework.service.security.SecurityManger;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.InvalidAlgorithmParameterException;

public class Login {

    @Autowired
    private SecurityManger securityManger;

    // TODO ez a fő method
    public boolean isUserEmailAndPasswordCorrect(String email, String password, Userrepository userRepository) {
        if(userRepository.existsByEmail(email)){
            return isPasswordCorrect(email, password, userRepository);
        }else{
            new InvalidAlgorithmParameterException("Your email is not correct");
        }
        return false;
    }

    public boolean isPasswordCorrect(String email, String password, Userrepository userRepository){
        User user = userRepository.getByEmail(email);
        String userHashedPassword = user.getPassword();
        return securityManger.matchPasswords(password, userHashedPassword);
    }


}
