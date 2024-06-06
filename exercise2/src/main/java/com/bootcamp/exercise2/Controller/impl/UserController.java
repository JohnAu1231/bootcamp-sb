package com.bootcamp.exercise2.Controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.exercise2.Controller.UserOperation;
import com.bootcamp.exercise2.model.mapper.UserMapper;
import com.bootcamp.exercise2.model.respDto.UserDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO.CommentDTO;
import com.bootcamp.exercise2.service.UserService;

@RestController
public class UserController implements UserOperation {

  @Autowired
  private UserService userService;

  @Autowired
  private UserMapper userMapper;

  // @Override
  // public List<UserDTO> getUsers() {

  // userService.getComments();
  // userService.getPosts();
  // return userService.getUsers().stream() //
  // .map(e -> userMapper.mapToUserDTO(e)) //
  // .collect(Collectors.toList());
  // }

  @Override
  public List<UserDTO> getUsers() {

    return userService.getUsers().stream() //
        .map(e -> {
          System.out.println("------test--------");
          UserDTO u = userMapper.mapToUserDTO( //
              e, //
              userService.getPosts(), //
              userService.getComments()); //
          System.out.println("-----------result=" + u);
          return u;
        }) //
        .collect(Collectors.toList());
  }



}
