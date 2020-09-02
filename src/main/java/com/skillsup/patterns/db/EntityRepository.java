package com.skillsup.patterns.db;

public interface EntityRepository {

    public void save(UserEntity userEntity);
    public UserEntity findUser(CredentialsEntity credentialsEntity);
}
