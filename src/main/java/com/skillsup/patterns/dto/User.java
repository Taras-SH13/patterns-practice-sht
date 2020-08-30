package com.skillsup.patterns.dto;


public class User {
    private final long id;
    private final String login;
    private final String password;
    private final Credentials credentials;

    public User(long id, String login, String password,Credentials credentials) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.credentials=credentials;
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
    public Credentials getCredentials(){return credentials};


    public static class UserBuilder {
        private long id;
        private String login;
        private String password;
        private Credentials credentials;

        public UserBuilder setUserId(long id) {
            this.id = id;
            return this;
        }

        public UserBuilder setUserLogin(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder setUserpassword(String password) {
            this.password = password;
            return this;
        }


    }
}
