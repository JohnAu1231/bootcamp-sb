package com.bootcamp.post.service;

import java.util.List;
import com.bootcamp.post.model.dto.ExPostDTO;

public interface PostService {
  
  List<ExPostDTO> getPosts();
}
