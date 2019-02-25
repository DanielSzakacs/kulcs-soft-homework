package com.daniel.szakacs.kulcssofthomework.controller;

import com.daniel.szakacs.kulcssofthomework.DAO.repository.AdminRepo;
import com.daniel.szakacs.kulcssofthomework.service.login.Login;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private Login login;

    @Autowired
    private AdminRepo adminRepo;


    @PostMapping("/login")
    public SocketFlow.Status makeLogin(@RequestBody Map<String, Object> loginData){
        if(login.isUserEmailAndPasswordCorrect(loginData.get("email").toString(), loginData.get("password").toString(), adminRepo)){
            return SocketFlow.Status.OK;
        }
        return SocketFlow.Status.NOT_SUPPORTED;
    }
}
