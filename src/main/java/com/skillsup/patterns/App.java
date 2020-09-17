package com.skillsup.patterns;


import com.skillsup.patterns.db.EntityRepositoryImpl;
import com.skillsup.patterns.db.UsersDB;
import com.skillsup.patterns.dto.Converter;
import com.skillsup.patterns.dto.Credentials;
import com.skillsup.patterns.dto.User;

/**
 * This class was created for demonstration
 * at the initial stage, the system prompts you to enter your username and password
 * create credentials from user password and user unique login
 * checking the access level
 */
public class App {

    public static final EntityRepositoryImpl REPOSITORY = new EntityRepositoryImpl();


    public static void main(String[] args) {
        // create Proxy server
        Proxy verification = new Proxy();
        //create ADMIN
        User adminUser = new
                User.UserBuilder().setUserId(11).setUserLogin("admin")
                .setUserPassword("admin")
                .setCredentials(new Credentials.CredentialsBuilder().setLogin("admin")
                        .setPassword("admin").create()).setUserRole(UserRole.ADMIN).toCreate();



        REPOSITORY.save(Converter.userToUserEntity(adminUser));

        //create registred USER
        User simpleUser = new
                User.UserBuilder().setUserId(3).setUserLogin("user")
                .setUserPassword("user")
                .setCredentials(new Credentials.CredentialsBuilder().setLogin("user")
                        .setPassword("user").create()).setUserRole(UserRole.COMMON).toCreate();

        REPOSITORY.save(Converter.userToUserEntity(simpleUser));

        // create a request from unregistered user
        Credentials newCredentials = new Credentials.CredentialsBuilder().setLogin("newUser").setPassword("1").create();


        System.out.println(verification.callFindUsers(newCredentials));
    }


}