package com.daniel.szakacs.kulcssofthomework.service.registration;

import com.daniel.szakacs.kulcssofthomework.service.module.User;

import com.daniel.szakacs.kulcssofthomework.DAO.repository.Userrepository;
import com.daniel.szakacs.kulcssofthomework.service.security.SecurityManger;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationHandler {

    @Autowired
    private Userrepository userrepository;

    @Autowired
    private SecurityManger securityManger;

    public boolean isNewUserSaved(String name, String email, String password){
        if(!isUserNameInUse(email)){
            String hashedPassword = hashNewUserPassword(password);
            User newUser = createUser(name, email, hashedPassword);
            saveNewUserData(newUser);
        }
        return true;
    }

    private User createUser(String name, String password, String email){
        return new User(name, email, password);
    }

    private boolean isUserNameInUse(String email){
        return userrepository.existsByEmail(email);
    }

    private String hashNewUserPassword(String password){
        return securityManger.hashingCode(password);
    }

    private void saveNewUserData(User user){
        userrepository.save(user);
    }


}
