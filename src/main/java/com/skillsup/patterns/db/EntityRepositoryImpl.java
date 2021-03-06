package com.skillsup.patterns.db;

import com.skillsup.patterns.UnauthorizedAccessException;
import com.skillsup.patterns.dto.Credentials;
import com.skillsup.patterns.dto.User;


import java.util.HashMap;
import java.util.Map;

public class EntityRepositoryImpl implements EntityRepository {

    private UserEntity user;
    private Credentials credentials;
    private Map db = UsersDB.getDboffUsers();

    @Override
    public void save(UserEntity userEntity) {
        db.put(userEntity.getCredentials(), userEntity);
    }

    @Override
    public UserEntity findUser(Credentials credentials) {
        if (chek(credentials) == false) {

            throw new UnauthorizedAccessException("No access!");

        }return (UserEntity) db.get(credentials);

        }

    public boolean chek(Credentials credentials) {
        return db.containsKey(credentials);
    }
}
