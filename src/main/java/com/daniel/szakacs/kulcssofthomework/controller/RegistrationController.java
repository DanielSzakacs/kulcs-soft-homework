package com.daniel.szakacs.kulcssofthomework.controller;

import com.daniel.szakacs.kulcssofthomework.DAO.repository.AdminRepo;
import com.daniel.szakacs.kulcssofthomework.service.registration.RegistrationHandler;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class RegistrationController {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    RegistrationHandler registrationHandler;

    @PostMapping("/registration")
    public SocketFlow.Status registration(@RequestBody Map<String, Object> userData){
        if(registrationHandler.isNewUserSaved(userData.get("email").toString(), userData.get("password").toString())){
            return SocketFlow.Status.OK;
        }else{
            return SocketFlow.Status.NOT_SUPPORTED;
        }
    }
}
