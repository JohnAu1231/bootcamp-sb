package com.bootcamp.exercise2.service;

import java.util.List;
import com.bootcamp.exercise2.model.User;
import com.bootcamp.exercise2.model.reqDto.ExCommentDTO;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.reqDto.ExUserDTO;

public interface UserService {
  
  List<ExUserDTO> getUsers();

  List<ExPostDTO> getPosts();

  List<ExCommentDTO> getComments();
}
