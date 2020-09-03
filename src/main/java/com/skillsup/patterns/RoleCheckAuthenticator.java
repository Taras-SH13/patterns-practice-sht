package com.skillsup.patterns;

import com.skillsup.patterns.db.EntityRepositoryImpl;
import com.skillsup.patterns.dto.Credentials;

public class RoleCheckAuthenticator implements UserAuthenticator {
    UserAuthenticator next;
    EntityRepositoryImpl entityRepository = new EntityRepositoryImpl();

    public void setNext(UserAuthenticator next) {
        this.next = next;

    }

    @Override
    public UserRole authenticate(Credentials credentials) {
        if (entityRepository.findUser(credentials).getUserRole().equals(UserRole.COMMON)) {
            System.out.println("Hello, USER!");
            return UserRole.COMMON;
        }

            return next.authenticate(credentials);
        }
    }
