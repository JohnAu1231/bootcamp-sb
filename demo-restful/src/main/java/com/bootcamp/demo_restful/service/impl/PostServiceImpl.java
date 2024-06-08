package com.bootcamp.demo_restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo_restful.entity.PostEntity;
import com.bootcamp.demo_restful.repository.PostRespository;
import com.bootcamp.demo_restful.service.PostService;

@Service
public class PostServiceImpl implements PostService{
  
  @Autowired
  private PostRespository postRespository;

  public PostEntity savePost(PostEntity post) {
    return postRespository.save(post);
  }
}
