package com.skillsup.patterns.db;

public class CredentialsEntity {
    private String login;
    private String password;

    public CredentialsEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
