package com.skillsup.patterns;

import com.skillsup.patterns.db.EntityRepositoryImpl;
import com.skillsup.patterns.db.UsersDB;
import com.skillsup.patterns.dto.Converter;
import com.skillsup.patterns.dto.Credentials;
import com.skillsup.patterns.dto.User;

import java.util.List;
import java.util.stream.Collectors;


public class UserServiceImp implements UserService {
    private static long id;
    private Credentials credentials;
    private EntityRepositoryImpl entityRepository = new EntityRepositoryImpl();
    private List<User> userList;

    @Override
    public User createUser(Credentials credentials) {
        id = id++;

        return new User.UserBuilder()
                .setUserId(id)
                .setUserLogin(credentials.getLogin())
                .setUserPassword(credentials.getPassword())
                .setUserRole(UserRole.COMMON)
                .setCredentials(credentials)
                .toCreate();
    }

    @Override
    public boolean deleteUser(long id) {
        credentials = UsersDB.getDboffUsers().values().stream().filter(x -> x.getId() == id).findAny().get().getCredentials();
        UsersDB.getDboffUsers().remove(UsersDB.getDboffUsers().values().stream().filter(x -> x.getId() == id).findAny().get().getCredentials());
        return entityRepository.chek(credentials);

    }

    @Override
    public List<User> findAllUsers(Credentials credentials) {
       return userList=UsersDB.getDboffUsers().values().stream().map(Converter::userEntitytoUser).collect(Collectors.toList());
    }

    @Override
    public User findUser(Credentials credentials) {

        return Converter.userEntitytoUser(entityRepository.findUser(credentials));
    }
}
