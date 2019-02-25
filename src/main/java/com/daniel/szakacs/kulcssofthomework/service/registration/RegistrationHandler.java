package com.daniel.szakacs.kulcssofthomework.service.registration;

import com.daniel.szakacs.kulcssofthomework.service.module.Admin;

import com.daniel.szakacs.kulcssofthomework.DAO.repository.AdminRepo;
import com.daniel.szakacs.kulcssofthomework.service.security.SecurityManger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationHandler {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private SecurityManger securityManger;

    public boolean isNewUserSaved(String email, String password){
        if(!isUserNameInUse(email)){
            String hashedPassword = hashNewUserPassword(password);
            Admin newAdmin = createUser(email, hashedPassword);
            saveNewUserData(newAdmin);
            return true;
        }else{
            return false;
        }
    }

    private Admin createUser(String email, String password){
        return new Admin(email, password);
    }

    private boolean isUserNameInUse(String email){
        try{
            return adminRepo.existsByEmail(email);
        }catch (Exception e){
            return false;
        }
    }

    private String hashNewUserPassword(String password){
        return securityManger.hashingCode(password);
    }

    private void saveNewUserData(Admin admin){
        adminRepo.save(admin);
    }


}
