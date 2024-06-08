package com.bootcamp.exercise2.service;

import java.util.List;
import com.bootcamp.exercise2.entity.UserEntity;
import com.bootcamp.exercise2.model.User;
import com.bootcamp.exercise2.model.reqDto.ExCommentDTO;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.reqDto.ExUserDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO;

public interface UserService {
  
  void saveUsers();

  UserEntity getUser(Long id);

  List<ExUserDTO> getUsers();

  List<UserEntity> getUsersFromDB();


}
