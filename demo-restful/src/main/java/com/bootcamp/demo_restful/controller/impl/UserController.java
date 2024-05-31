package com.bootcamp.demo_restful.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_restful.controller.UserOperation;
import com.bootcamp.demo_restful.dto.UserDTO;
import com.bootcamp.demo_restful.dto.mapper.UserMapper;
import com.bootcamp.demo_restful.entity.UserEntity;
import com.bootcamp.demo_restful.model.dto.User;
import com.bootcamp.demo_restful.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value = "/v1")
public class UserController implements UserOperation {
  
  @Autowired
  private UserService userService;

  @Autowired
  private UserMapper mapper;

  @Autowired
  private List<User> userList;

  @Override
  public List<UserDTO> getUsers() {
    if (userList.isEmpty()) {
      userService.getUsers().stream() //
                 .forEach(e -> userList.add(e));
    return userList.stream() //
                   .map(e -> mapper.mapToUser(e)) //
                   .collect(Collectors.toList());
    } else {
      System.out.println("is not empty");
        return userList.stream() //
                       .map(e -> mapper.mapToUser(e)) //
                       .collect(Collectors.toList());
    }
}

  @Override
  public User saveUser(User user) {
    return userService.save(user);
  }

  @Override
  public UserEntity saveUser(UserEntity user) {
    return userService.save(user);
  }
}
