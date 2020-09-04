package com.skillsup.patterns;

import com.skillsup.patterns.dto.Credentials;

public interface UserAuthenticator {

    /**
     * This method is needed to identify who is trying to access the system
     *
     * @param credentials user passwrod and user unique login
     * @return role of the user who's credentials are checked
     */
    UserRole authenticate(Credentials credentials);

    UserAuthenticator setNext(UserAuthenticator next);


}
