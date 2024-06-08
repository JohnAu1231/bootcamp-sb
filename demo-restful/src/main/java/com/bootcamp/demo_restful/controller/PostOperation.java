package com.bootcamp.demo_restful.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootcamp.demo_restful.entity.PostEntity;

public interface PostOperation {
  
  @PostMapping(value = "/post/save")
  PostEntity savePost(@RequestBody PostEntity post);
}
