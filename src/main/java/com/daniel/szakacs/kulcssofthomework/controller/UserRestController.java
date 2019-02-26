package com.daniel.szakacs.kulcssofthomework.controller;

import com.daniel.szakacs.kulcssofthomework.DAO.repository.UserRepo;
import com.daniel.szakacs.kulcssofthomework.service.module.User;
import com.daniel.szakacs.kulcssofthomework.service.userhandler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@CrossOrigin
@RestController
public class UserRestController {

    @Autowired
    UserHandler userHandler;

    @PostMapping("/saveuser")
    public void saveNewUser(@RequestBody Map<String, Object> userData){
        userHandler.saveUser(userData.get("email").toString(), userData.get("name").toString());
    }

    @GetMapping("/get_all_user")
    public Set<User> getAllUser(){
        return userHandler.getAllUser();
    }

    @DeleteMapping("/delete_user")
    public void deleteUser(@RequestParam(name = "user", required = true) String email){
        this.userHandler.deleteUserById(email);
    }

}
