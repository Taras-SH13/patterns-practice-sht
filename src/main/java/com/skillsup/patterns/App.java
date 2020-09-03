package com.skillsup.patterns;


import com.skillsup.patterns.db.EntityRepositoryImpl;
import com.skillsup.patterns.db.UsersDB;
import com.skillsup.patterns.dto.Converter;
import com.skillsup.patterns.dto.Credentials;
import com.skillsup.patterns.dto.User;

public class App {
    public static void main(String[] args) throws UnauthorizedAccessException {
        User adminUser = new
                User.UserBuilder().setUserId(1).setUserLogin("admin")
                .setUserPassword("admin")
                .setCredentials(new Credentials.CredentialsBuilder().setLogin("admin")
                        .setPassword("admin").create()).setUserRole(UserRole.ADMIN).toCreate();

        new EntityRepositoryImpl().save(Converter.userToUserEntity(adminUser));

        User simpleUser = new
                User.UserBuilder().setUserId(2).setUserLogin("user")
                .setUserPassword("user")
                .setCredentials(new Credentials.CredentialsBuilder().setLogin("user")
                        .setPassword("user").create()).setUserRole(UserRole.COMMON).toCreate();

        new EntityRepositoryImpl().save(Converter.userToUserEntity(simpleUser));
        Credentials newCredentials=new Credentials.CredentialsBuilder().setLogin("newUser").setPassword("1").create();
        UserAuthenticator userAuthenticator=new UserAuthenticatorImpl();
        System.out.println(userAuthenticator.authenticate(adminUser.getCredentials()));
    }

}