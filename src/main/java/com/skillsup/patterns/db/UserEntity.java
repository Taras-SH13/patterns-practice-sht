package com.skillsup.patterns.db;

import com.skillsup.patterns.UserRole;
import com.skillsup.patterns.dto.Credentials;

public class UserEntity {
    private long id;
    private String login;
    private String password;
    private Credentials credentials;
    private UserRole userRole;

    public UserEntity(long id, String login, String password, Credentials credentials, UserRole userRole) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.credentials = credentials;
        this.userRole = userRole;
    }


    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}
