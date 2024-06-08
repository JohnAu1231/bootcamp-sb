package com.bootcamp.demo_restful.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_restful.controller.PostOperation;
import com.bootcamp.demo_restful.entity.PostEntity;
import com.bootcamp.demo_restful.service.PostService;

@RestController
@RequestMapping(value = "/v1")
public class PostController implements PostOperation{
  
  @Autowired
  private PostService postService;

  @Override
  public PostEntity savePost(PostEntity post) {
    return postService.savePost(post);
  }
}
