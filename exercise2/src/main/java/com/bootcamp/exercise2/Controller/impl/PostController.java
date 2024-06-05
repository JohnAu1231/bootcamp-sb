package com.bootcamp.exercise2.Controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.exercise2.Controller.PostOperation;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.service.UserService;

@RestController
public class PostController implements PostOperation{
  
  @Autowired
  private UserService userService;
  @Override
  public List<ExPostDTO> getPosts() {
    return userService.getPosts();
  }
}
