package com.daniel.szakacs.kulcssofthomework.DAO.repository;

import com.daniel.szakacs.kulcssofthomework.service.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface Userrepository extends JpaRepository<User, Long> {

    //Used for registration and login
    boolean existsByEmail(String email);

    //Used for Login
    User getByEmail(String email);


}
