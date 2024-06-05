package com.bootcamp.post.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.post.model.dto.ExPostDTO;

public interface PostOperation {
  @GetMapping(value = "/posts")
  @ResponseStatus(value = HttpStatus.OK)
  List<ExPostDTO> allPosts();
}
