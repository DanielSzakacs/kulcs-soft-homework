package com.daniel.szakacs.kulcssofthomework.DAO.repository;

import com.daniel.szakacs.kulcssofthomework.service.module.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AdminRepo extends JpaRepository<Admin, Long> {

    //Used for registration and login
    boolean existsByEmail(String email);

    //Used for Login
    Admin getByEmail(String email);


}
