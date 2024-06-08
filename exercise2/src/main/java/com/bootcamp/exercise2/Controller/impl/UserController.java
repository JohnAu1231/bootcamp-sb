package com.bootcamp.exercise2.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.exercise2.controller.UserOperation;
import com.bootcamp.exercise2.infra.ApiResp;
import com.bootcamp.exercise2.model.mapper.UserEntityMapper;
import com.bootcamp.exercise2.model.mapper.UserMapper;
import com.bootcamp.exercise2.model.reqDto.ExUserDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO.CommentDTO;
import com.bootcamp.exercise2.respository.UserRespository;
import com.bootcamp.exercise2.service.CommentService;
import com.bootcamp.exercise2.service.PostService;
import com.bootcamp.exercise2.service.UserService;

@RestController
public class UserController implements UserOperation {

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private CommentService commentService;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserEntityMapper userEntityMapper;

  @Autowired
  private UserRespository userRespository;

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
          UserDTO u = userMapper.mapToUserDTO( //
              e, //
              postService.getPosts(), //
              commentService.getComments()); //
          return u;
        }) //
        .collect(Collectors.toList());
  }

  // @Override 
  // public ApiResp<UserDTO> getUsersFromDB() {
  //   return userService.getUsersFromDB().stream() //
  //           .map(e -> mapToUserDTO)
  // }



  @Override
  public UserDTO getUser(Long id) {
  // return userEntityMapper.mapToUserDTO(userService.getUser(id), );
  return null;
  }



}
