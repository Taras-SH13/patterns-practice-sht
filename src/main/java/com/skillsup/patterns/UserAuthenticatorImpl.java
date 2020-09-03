package com.skillsup.patterns;

import com.skillsup.patterns.db.EntityRepository;
import com.skillsup.patterns.db.EntityRepositoryImpl;
import com.skillsup.patterns.dto.Converter;
import com.skillsup.patterns.dto.Credentials;
import com.skillsup.patterns.dto.User;

public class UserAuthenticatorImpl implements UserAuthenticator {
    UserAuthenticator next;
    EntityRepositoryImpl entityRepository = new EntityRepositoryImpl();
    User user;

    public UserAuthenticator setNext(UserAuthenticator next) {
        this.next = next;
        return next;
    }


    @Override
    public UserRole authenticate(Credentials credentials) throws UnauthorizedAccessException {

        try {
            if (entityRepository.chek(credentials) == false)
                throw new UnauthorizedAccessException("Нет такого пользователя!");
        } catch (UnauthorizedAccessException e) {
            System.out.println(e.getMessage());
        }
        if (next != null) {
            next.authenticate(credentials);
        }
        return UserRole.UNKNOWN;
    }
}