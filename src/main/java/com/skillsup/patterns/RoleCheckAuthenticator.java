package com.skillsup.patterns;

import com.skillsup.patterns.dto.Credentials;

public class RoleCheckAuthenticator implements UserAuthenticator{

    @Override
    public UserRole authenticate(Credentials credentials) throws UnauthorizedAccessException {
        return null;
    }
}
