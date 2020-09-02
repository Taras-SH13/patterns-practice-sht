package com.skillsup.patterns.dto;

import com.skillsup.patterns.db.CredentialsEntity;
import com.skillsup.patterns.db.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static UserEntity userToUserEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getCredentials(),
                user.getUserRole()
        );
    }


    public static User userEntitytoUser(UserEntity userEntity) {
        return new User.UserBuilder()
                .setUserId(userEntity.getId())
                .setUserLogin(userEntity.getLogin())
                .setCredentials(userEntity.getCredentials())
                .setUserRole(userEntity.getUserRole())
                .toCreate();
    }

    public static CredentialsEntity credentialsToCredentialsEntity(Credentials credentials) {
        return new CredentialsEntity(
                credentials.getLogin(),
                credentials.getPassword()
        );
    }
    public static Credentials credentialsEntitytoCredentials(CredentialsEntity credentialsEntity) {
        return new Credentials.CredentialsBuilder()
                .setLogin(credentialsEntity.getLogin())
                .setPassword(credentialsEntity.getPassword())
                .create();
    }
}
