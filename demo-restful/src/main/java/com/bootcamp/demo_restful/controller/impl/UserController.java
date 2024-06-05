package com.bootcamp.demo_restful.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_restful.controller.UserOperation;
import com.bootcamp.demo_restful.dto.mapper.UserMapper;
import com.bootcamp.demo_restful.dto.reqDto.UserReqDTO;
import com.bootcamp.demo_restful.dto.resoDto.UserDTO;
import com.bootcamp.demo_restful.entity.UserEntity;
import com.bootcamp.demo_restful.infra.ApiResp;
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
  public ApiResp<UserDTO> getUsers() {
    if (userList.isEmpty()) {
      userService.getUsers().stream() //
          .forEach(e -> userList.add(e));
      List<UserDTO> result = userList.stream() //
          .map(e -> mapper.mapToUser(e)) //
          .collect(Collectors.toList());
      return ApiResp.<UserDTO>builder() //
          .ok() //
          .data(result) //
          .build();
    } else {
      System.out.println("is not empty");
      return ApiResp.<UserDTO>builder() //
          .ok() //
          .data(userList.stream() //
              .map(e -> mapper.mapToUser(e)) //
              .collect(Collectors.toList())) //
          .build();
    }
  }

  @Override
  public ApiResp<UserEntity> getUserById(Long id) {
    return ApiResp.<UserEntity>builder() //
            .ok() //
            .data(List.of(userService.getUserById(id))) //
            .build();
  }

  @Override
  public ApiResp<UserEntity> getUserByName(String name) {
    return ApiResp.<UserEntity>builder() //
            .ok() //
            .data(userService.getUserByName(name)) //
            .build();
  }

  @Override
  public ApiResp<UserEntity> getUserByNameOrderById(String name) {
    return ApiResp.<UserEntity>builder() //
            .ok() //
            .data(userService.getUserNameOrderById(name)) //
            .build();
  }
  @Override
  public ApiResp<UserEntity> deleteUser(Long id) {
    return ApiResp.<UserEntity>builder() //
            .ok() //
            .data(List.of(userService.deleteById(id))) //
            .build();
  }
  // @Override
  // public User saveUser(User user) {
  // return userService.save(user);
  // }

  @Override
  public ApiResp<UserEntity> saveUser(UserEntity user) {
    return ApiResp.<UserEntity>builder() //
        .ok() //
        .data(List.of(userService.save(user))) //
        .build();
  }

  @Override
  public ApiResp<UserEntity> updateUser(Long id, UserEntity user) {
    return ApiResp.<UserEntity>builder() //
            .ok() //
            .data(List.of(userService.updateUser(id, user))) //
            .build();
  }

  @Override
  public ApiResp<UserEntity> updateUserEmailById(Long id, UserReqDTO userReqDTO) {
    return ApiResp.<UserEntity>builder() //
            .ok() //
            .data(List.of(userService.updateEmailById(id, userReqDTO))) //
            .build();
  }
}


