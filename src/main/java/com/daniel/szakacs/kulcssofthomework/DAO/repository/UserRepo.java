package com.daniel.szakacs.kulcssofthomework.DAO.repository;

import com.daniel.szakacs.kulcssofthomework.service.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public interface UserRepo extends JpaRepository<User, Long> {

    Set<User> findAllByOrderById();

    @Transactional
    void removeAllByEmail(String email);
}
