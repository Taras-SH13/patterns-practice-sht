package com.skillsup.patterns;

import com.skillsup.patterns.db.EntityRepository;
import com.skillsup.patterns.db.EntityRepositoryImpl;
import com.skillsup.patterns.dto.Converter;
import com.skillsup.patterns.dto.Credentials;
import com.skillsup.patterns.dto.User;

public class UserAuthenticatorImpl implements UserAuthenticator {
    UserAuthenticator next;
    EntityRepositoryImpl entityRepository = new EntityRepositoryImpl();


    public void setNext(UserAuthenticator next) {
        this.next = next;
    }

    @Override
    public UserRole authenticate(Credentials credentials) {
        try {
            return entityRepository.findUser(credentials).getUserRole();
        } catch (NullPointerException e) {
            System.out.println("This user is not registered!!");
            return UserRole.UNKNOWN;
        } finally {
            if (next != null)
                return next.authenticate(credentials);
        }

    }

}