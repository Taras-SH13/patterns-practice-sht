package com.skillsup.patterns.db;

import com.skillsup.patterns.dto.Credentials;
import com.skillsup.patterns.dto.User;


import java.util.HashMap;
import java.util.Map;

public class EntityRepositoryImpl implements EntityRepository {

    private UserEntity user;
    private Credentials credentials;
    private Map db = UsersDB.getDboffUsers();

    @Override
    public void save() {
        db.put(credentials,user);
    }

    @Override
    public void find() {
        db.get(credentials);
    }


}
