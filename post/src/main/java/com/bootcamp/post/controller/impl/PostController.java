package com.bootcamp.post.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.post.controller.PostOperation;
import com.bootcamp.post.model.dto.ExPostDTO;
import com.bootcamp.post.service.PostService;

@RestController
public class PostController implements PostOperation {
  
  @Autowired
  private PostService postService;

  @Override
  public List<ExPostDTO> allPosts() {
    return postService.getPosts();
  }
}
