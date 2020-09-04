package com.skillsup.patterns;

import com.skillsup.patterns.db.EntityRepositoryImpl;
import com.skillsup.patterns.dto.Credentials;

public class AdminAuthenticator implements UserAuthenticator {
    UserAuthenticator next;
    EntityRepositoryImpl entityRepository = new EntityRepositoryImpl();

    public UserAuthenticator setNext(UserAuthenticator next) {
        this.next = next;
        return next;
    }

    @Override
    public UserRole authenticate(Credentials credentials) {
        if (entityRepository.findUser(credentials).getUserRole().equals(UserRole.ADMIN)) {
            System.out.println("Hello, ADMIN!");
            return UserRole.ADMIN;
        }

        return UserRole.UNKNOWN;
    }
}
