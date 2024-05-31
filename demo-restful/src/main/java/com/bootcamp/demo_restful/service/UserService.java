package com.bootcamp.demo_restful.service;

import java.util.List;
import com.bootcamp.demo_restful.entity.UserEntity;
import com.bootcamp.demo_restful.model.dto.User;

public interface UserService {
  
  List<User> getUsers();

  // User save(User user);

  UserEntity save(UserEntity user);
}
