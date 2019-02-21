package com.daniel.szakacs.kulcssofthomework.service.repository;

import com.daniel.szakacs.kulcssofthomework.service.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface Userrepository extends JpaRepository<User, Long> {
}
