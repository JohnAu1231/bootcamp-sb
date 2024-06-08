package com.bootcamp.exercise2.service;

import java.util.List;
import com.bootcamp.exercise2.entity.PostEntity;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;

public interface PostService {
  List<ExPostDTO> getPosts();

  List<PostEntity> getPostsFromDB();
}
