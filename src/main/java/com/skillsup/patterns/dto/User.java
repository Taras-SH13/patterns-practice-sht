package com.skillsup.patterns.dto;


import com.skillsup.patterns.UserRole;

public class User {
    private final long id;
    private final String login;
    private final String password;
    private final Credentials credentials;
    private final UserRole userRole;

    private User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.login = userBuilder.login;
        this.password = userBuilder.password;
        this.credentials = userBuilder.credentials;
        this.userRole = userBuilder.userRole;
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


    public static class UserBuilder {
        private long id;
        private String login;
        private String password;
        private Credentials credentials;
        private UserRole userRole;

        public UserBuilder setUserId(long id) {
            this.id = id;
            return this;
        }

        public UserBuilder setUserLogin(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder setUserPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setUserCredentials(Credentials credentials) {
            this.credentials = credentials;
            return this;
        }

        public UserBuilder setUserRole(UserRole userRole) {
            this.userRole = userRole;
            return this;
        }

        public User toCreate() {
            return new User(this);
        }
    }
}
