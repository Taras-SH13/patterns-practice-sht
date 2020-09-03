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

    public void setNext(UserAuthenticator next) {
        this.next = next;
    }

    @Override
    public UserRole authenticate(Credentials credentials) {

      user=Converter.userEntitytoUser(entityRepository.findUser(Converter.credentialsToCredentialsEntity(credentials)));
      if(user==null){
          System.out.println("This user is not registered!");
      }
      if(next!=null){
         next.authenticate(credentials);
      }
      return UserRole.UNKNOWN;
}
}