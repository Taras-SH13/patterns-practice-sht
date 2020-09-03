package com.skillsup.patterns.db;

import com.skillsup.patterns.dto.Credentials;

import java.util.HashMap;
import java.util.Map;

public final class UsersDB {
    // singleton realization
    private static Map<Credentials,UserEntity> dboffUsers;

    private UsersDB() {
    }

    public static Map<Credentials,UserEntity> getDboffUsers() {
        if (dboffUsers == null) {
            dboffUsers = new HashMap<>();
        }
        return dboffUsers;
    }
}
