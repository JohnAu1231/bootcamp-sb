package com.bootcamp.exercise2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.exercise2.entity.UserEntity;
import com.bootcamp.exercise2.infra.ApiResp;
import com.bootcamp.exercise2.model.respDto.UserDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO.CommentDTO;

public interface UserOperation {
  
  @GetMapping(value = "/users")
  ApiResp<UserDTO> getUsers();

  // @GetMapping(value = "/users")
  // ApiResp<UserDTO> getUsersFromDB();

  @GetMapping(value = "/user")
  ApiResp<UserDTO> getUser(@RequestParam Long id);

  @PutMapping(value = "/user/update")
  ApiResp<UserEntity> update(@RequestBody UserDTO user);

  @GetMapping(value = "/userE")
  ApiResp<UserEntity> getUserEntity(@RequestParam Long id);

}
