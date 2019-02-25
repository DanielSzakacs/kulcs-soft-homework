package com.daniel.szakacs.kulcssofthomework.controller;

import com.daniel.szakacs.kulcssofthomework.DAO.repository.AdminRepo;
import com.daniel.szakacs.kulcssofthomework.service.registration.RegistrationHandler;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@CrossOrigin
@RestController
public class RegistrationController {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    RegistrationHandler registrationHandler;

    @PostMapping("/registration")
    public void registration(@RequestBody Map<String, Object> userData){
        if(!registrationHandler.isNewUserSaved(userData.get("email").toString(), userData.get("password").toString())){
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "registration cant happen"
            );
        }
    }
}
