package com.skillsup.patterns.db;

import java.util.HashMap;
import java.util.Map;

public final class UsersDB {
    // singleton realization
    private static Map<CredentialsEntity,UserEntity> dboffUsers;

    private UsersDB() {
    }

    public static Map<CredentialsEntity,UserEntity> getDboffUsers() {
        if (dboffUsers == null) {
            dboffUsers = new HashMap<>();
        }
        return dboffUsers;
    }
}
