package com.bootcamp.bookservice.service;

import java.util.Optional;
import com.bootcamp.bookservice.model.User;

public interface UserService {
  
  public Optional<User> getUser(String name);

  public User addUser(String name);

  
}
