package com.daniel.szakacs.kulcssofthomework.controller;

import com.daniel.szakacs.kulcssofthomework.DAO.repository.Userrepository;
import com.daniel.szakacs.kulcssofthomework.service.login.Login;
import com.sun.org.apache.xerces.internal.util.Status;
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
    private Userrepository userrepository;


    @PostMapping("/login")
    public SocketFlow.Status makeLogin(@RequestBody Object loginData){
        System.out.println("This is the login data: " + loginData);
//        if(login.isUserEmailAndPasswordCorrect(loginData.get("email"), loginData.get("password"), userrepository)){
//            return SocketFlow.Status.OK;
//        }
//        return SocketFlow.Status.NOT_SUPPORTED;
        return SocketFlow.Status.OK;

    }
}
