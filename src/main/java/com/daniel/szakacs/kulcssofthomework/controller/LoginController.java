package com.daniel.szakacs.kulcssofthomework.controller;

import com.daniel.szakacs.kulcssofthomework.DAO.repository.Userrepository;
import com.daniel.szakacs.kulcssofthomework.service.login.Login;
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
    public void makeLogin(@RequestBody Map<String, String> loginData){
        login.isUserEmailAndPasswordCorrect(loginData.get("email"), loginData.get("password"), userrepository);
    }
}
