package com.bootcamp.demo_restful.service;

import java.util.List;
import org.springframework.data.repository.query.Param;
import com.bootcamp.demo_restful.dto.reqDto.UserReqDTO;
import com.bootcamp.demo_restful.entity.UserEntity;
import com.bootcamp.demo_restful.model.dto.User;

public interface UserService {
  
  List<User> getUsers();

  UserEntity getUserById(Long id);

  UserEntity getUserByPhone(String phone);

  List<UserEntity> getUserByName(String name);

  List<UserEntity> getUserNameOrderById(String name);

  // User save(User user);

  UserEntity save(UserEntity user);

  UserEntity deleteById(Long id);

  UserEntity updateUser(Long id, UserEntity user);

  UserEntity updateEmailById(Long id, UserReqDTO userReqDTO);

  List<UserEntity> getUserbyAddLatGreaterThan(Double latitude);

   Integer updateUserEmail(Long id, String email);


}
