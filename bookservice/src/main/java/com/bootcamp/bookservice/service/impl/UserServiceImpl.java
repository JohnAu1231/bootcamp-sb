package com.bootcamp.bookservice.service.impl;

import java.util.Optional;
import javax.management.RuntimeErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import com.bootcamp.bookservice.config.AppConfig;
import com.bootcamp.bookservice.model.User;
import com.bootcamp.bookservice.service.UserService;

public class UserServiceImpl implements UserService {

@Autowired
public AppConfig appconfig;

  public Optional<User> getUser(String name) throws RuntimeException{

    try {
    for (User u: appconfig.getUsers()) {
      User ans;
      if (u.getName().equals(name)) {
        ans = u;
        return Optional.of(ans);
      }
    }
    return null;
  } catch (RuntimeException e) {
    throw new RuntimeException();
  }
    
  }

  public User addUser(String name) {
    User newUser = new User(name);
    appconfig.add(newUser);
    return newUser;
  }
  
}
