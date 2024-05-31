package com.bootcamp.demo_restful.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.demo_restful.dto.UserDTO;
import com.bootcamp.demo_restful.entity.UserEntity;
import com.bootcamp.demo_restful.model.dto.User;

public interface UserOperation {

  @GetMapping(value = "/jsonplaceholder/users")
  @ResponseStatus(value = HttpStatus.OK)
  List<UserDTO> getUsers();

  @PostMapping(value = "/users")
  @ResponseStatus(value = HttpStatus.OK)
  User saveUser(@RequestBody User user);

  @PostMapping(value = "/user")
  UserEntity saveUser(@RequestBody UserEntity user);
}
