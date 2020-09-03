package com.skillsup.patterns.db;

import com.skillsup.patterns.dto.Credentials;

public interface EntityRepository {

    public void save(UserEntity userEntity);
    public UserEntity findUser(Credentials credentials);
}
