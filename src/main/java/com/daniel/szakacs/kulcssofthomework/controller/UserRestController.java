package com.daniel.szakacs.kulcssofthomework.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class UserRestController {

    @GetMapping("/get_all_user")
    public String getAllUser(){
        return "";
    }

    @PutMapping("/saveuser")
    public void saveNewUser(@RequestBody Map<String, Object> userData){
        System.out.println(userData);
    }
}
