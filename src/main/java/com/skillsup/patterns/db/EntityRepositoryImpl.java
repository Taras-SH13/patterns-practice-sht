package com.skillsup.patterns.db;

import com.skillsup.patterns.dto.Credentials;
import com.skillsup.patterns.dto.User;
import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.util.HashMap;
import java.util.Map;

public class EntityRepositoryImpl implements EntityRepository {
    private final Map<UserEntity, Credentials> usersDB = new HashMap<>();
    private UserEntity user;
    private Credentials credentials;

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public void save() {
        usersDB.put(user, credentials);
    }

    @Override
    public void find() {

    }
}
