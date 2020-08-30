package com.skillsup.patterns.db;

import java.util.HashMap;
import java.util.Map;

public final class UsersDB {
    // singleton realization
    private static Map<UserEntity, CredentialsEntity> dboffUsers;

    public static Map<UserEntity, CredentialsEntity> getDboffUsers() {
        if (dboffUsers == null) {
            dboffUsers = new HashMap<>();
        }
        return dboffUsers;
    }
}
