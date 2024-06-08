package com.bootcamp.exercise2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.exercise2.infra.ApiResp;
import com.bootcamp.exercise2.model.respDto.UserDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO.CommentDTO;

public interface UserOperation {
  
  @GetMapping(value = "/users")
  List<UserDTO> getUsers();

  // @GetMapping(value = "/users")
  // ApiResp<UserDTO> getUsersFromDB();

  @GetMapping(value = "/user")
  UserDTO getUser(@RequestParam Long id);

  
  


}
