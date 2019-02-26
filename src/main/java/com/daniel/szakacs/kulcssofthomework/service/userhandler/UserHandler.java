package com.daniel.szakacs.kulcssofthomework.service.userhandler;

import com.daniel.szakacs.kulcssofthomework.DAO.repository.UserRepo;
import com.daniel.szakacs.kulcssofthomework.service.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserHandler {

    @Autowired
    UserRepo userRepo;

    public void saveUser(String name, String email){
        User newUser = new User(email, name);
        userRepo.save(newUser);
    }

    public Set<User> getAllUser(){
        return this.userRepo.findAllByOrderById();
    }
}