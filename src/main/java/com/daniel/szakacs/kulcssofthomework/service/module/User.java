package com.daniel.szakacs.kulcssofthomework.service.module;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "emailaddress")
    private String emailaddress;

    @Column(name = "username")
    private String userName;

    public User(){}

    public User(String email, String userName) {
        this.emailaddress = email;
        this.userName = userName;
    }

    public String getEmail() {
        return emailaddress;
    }

    public String getUserName() {
        return userName;
    }
}
