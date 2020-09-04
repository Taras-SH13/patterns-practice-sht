package com.skillsup.patterns;

import com.skillsup.patterns.db.EntityRepositoryImpl;
import com.skillsup.patterns.dto.Converter;
import com.skillsup.patterns.dto.Credentials;
import com.skillsup.patterns.dto.User;


import java.util.List;
import java.util.Scanner;

public class Proxy implements UserService, UserAuthenticator {

    private UserAuthenticator authenticator;
    private UserServiceImp userServiceImp = new UserServiceImp();
    private EntityRepositoryImpl entityRepository = new EntityRepositoryImpl();
    private Credentials credentials;
    private Scanner scanner = new Scanner(System.in);
    public void callCreateUser(Credentials credentials) {

        if (authenticator
                .setNext(new RoleCheckAuthenticator())
                .setNext(new AdminAuthenticator())
                .authenticate(credentials).equals(UserRole.UNKNOWN)) {
            entityRepository.save(Converter.userToUserEntity(userServiceImp.createUser(credentials)));
        } else {
            System.out.println("You are already registered!!!!");
        }
    }
public void callDeleteUser(Credentials credentials){

    if (authenticator
            .setNext(new RoleCheckAuthenticator())
            .setNext(new AdminAuthenticator())
            .authenticate(credentials).equals(UserRole.ADMIN)){
        System.out.println("Enter id -:");
        long id = scanner.nextLong();
        userServiceImp.deleteUser(id);
    }
    else {
        System.out.println("You do not have access rights!!!");
    }
}







    @Override
    public User createUser(Credentials credentials) {
        return null;
    }

    @Override
    public boolean deleteUser(long id) {
        return false;
    }

    @Override
    public List<User> findAllUsers(Credentials credentials) {
        return null;
    }

    @Override
    public User findUser(Credentials credentials) {
        return null;
    }

    @Override
    public UserRole authenticate(Credentials credentials) {
        return null;
    }

    @Override
    public UserAuthenticator setNext(UserAuthenticator next) {
        return null;
    }
}
