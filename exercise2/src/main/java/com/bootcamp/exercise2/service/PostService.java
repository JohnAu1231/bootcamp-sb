package com.bootcamp.exercise2.service;

import java.util.List;
import com.bootcamp.exercise2.entity.PostEntity;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO;

public interface PostService {
  List<ExPostDTO> getPosts();

  List<PostEntity> getPostsFromDB();

 void savePosts();

  List<PostEntity> getPostById(Long userId);

  PostEntity savePostByUserId(Long userId, String title, String body);

  PostEntity deletePost(Long postId);

}
