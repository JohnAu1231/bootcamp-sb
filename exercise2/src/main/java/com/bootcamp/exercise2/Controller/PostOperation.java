package com.bootcamp.exercise2.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;

public interface PostOperation {
  
  @GetMapping(value = "/posts")
  List<ExPostDTO> getPosts();
}
