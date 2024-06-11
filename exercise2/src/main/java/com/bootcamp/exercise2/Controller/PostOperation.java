package com.bootcamp.exercise2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.exercise2.entity.PostEntity;
import com.bootcamp.exercise2.entity.UserEntity;
import com.bootcamp.exercise2.infra.ApiResp;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO;

public interface PostOperation {
  
  
  List<ExPostDTO> getPosts();

  @GetMapping(value = "/posts")
  List<PostDTO> getPostsFromDB();

  @GetMapping(value = "/post/{userId}") 
  List<PostDTO> getPostByUserId(@PathVariable Long userId);

  @PostMapping(value = "/post/add/{userId}/{title}/{body}")
  ApiResp<PostEntity> addPost(@PathVariable Long userId, @PathVariable String title, @PathVariable String body);

  @DeleteMapping(value = "/post/{postId}")
  ApiResp<PostEntity> deletePost(@PathVariable Long postId);
  
}
