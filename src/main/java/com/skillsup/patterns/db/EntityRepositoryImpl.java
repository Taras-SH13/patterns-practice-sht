package com.skillsup.patterns.db;

import com.skillsup.patterns.dto.Credentials;
import com.skillsup.patterns.dto.User;
import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.util.HashMap;
import java.util.Map;

public class EntityRepositoryImpl implements EntityRepository {

    private UserEntity user;
    private Credentials credentials;
    private Map db = UsersDB.getDboffUsers();

    @Override
    public void save() {
        db.put(user, credentials);
    }

    @Override
    public void find() {
        db.get(user);
    }


}
