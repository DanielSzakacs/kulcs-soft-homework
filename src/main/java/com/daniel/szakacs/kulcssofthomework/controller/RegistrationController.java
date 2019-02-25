package com.daniel.szakacs.kulcssofthomework.controller;

import com.daniel.szakacs.kulcssofthomework.DAO.repository.Userrepository;
import com.daniel.szakacs.kulcssofthomework.service.registration.RegistrationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class RegistrationController {

    @Autowired
    Userrepository userrepository;

    @Autowired
    RegistrationHandler registrationHandler;

    @PostMapping("/registration")
    public void registration(@RequestBody Map<String, String> userData){
        registrationHandler.isNewUserSaved(userData.get("name"), userData.get("email"), userData.get("password"));
    }
}
