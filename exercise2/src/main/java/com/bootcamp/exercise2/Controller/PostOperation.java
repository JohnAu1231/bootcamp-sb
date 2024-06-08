package com.bootcamp.exercise2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO;

public interface PostOperation {
  
  
  List<ExPostDTO> getPosts();

  void savePosts();

  @GetMapping(value = "/posts")
  List<PostDTO> getPostsFromDB();

  
}
