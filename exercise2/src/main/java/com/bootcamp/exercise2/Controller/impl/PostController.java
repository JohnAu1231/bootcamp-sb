package com.bootcamp.exercise2.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.exercise2.controller.PostOperation;
import com.bootcamp.exercise2.entity.CommentEntity;
import com.bootcamp.exercise2.entity.PostEntity;
import com.bootcamp.exercise2.entity.UserEntity;
import com.bootcamp.exercise2.infra.ApiResp;
import com.bootcamp.exercise2.model.mapper.CommentEntityMapper;
import com.bootcamp.exercise2.model.mapper.PostEntityMapper;
import com.bootcamp.exercise2.model.mapper.UserEntityMapper;
import com.bootcamp.exercise2.model.mapper.UserMapper;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.reqDto.ExUserDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO.CommentDTO;
import com.bootcamp.exercise2.respository.PostRespository;
import com.bootcamp.exercise2.service.CommentService;
import com.bootcamp.exercise2.service.PostService;
import com.bootcamp.exercise2.service.UserService;

@RestController
public class PostController implements PostOperation {

  @Autowired
  private PostService postService;

  @Autowired
  private PostEntityMapper postEntityMapper;


  @Autowired
  private CommentService commentService;

  @Autowired 
  private CommentEntityMapper commentEntityMapper;

  @Override
  public List<ExPostDTO> getPosts() {
    return postService.getPosts();
  }

  @Override
  public List<PostDTO> getPostsFromDB() {
    return postService.getPostsFromDB().stream() //
        .map(e -> {
          List<CommentDTO> comments = commentService.getCommentsByPostId(e.getId()).stream()//
          .map(c -> commentEntityMapper.mapToCommentDTO(c)) //
          .collect(Collectors.toList());
          return postEntityMapper.mapToPostDTO(e, comments);
        }) //
        .collect(Collectors.toList());
  }

  @Override
  public List<PostDTO> getPostByUserId(Long userId) {
    List<CommentDTO> comments = commentService.getCommentsByUserIdFromDB(userId).stream() //
      .map(e -> commentEntityMapper.mapToCommentDTO(e)) //
      .collect(Collectors.toList()); //
    return postService.getPostById(userId).stream() //
        .map(e -> postEntityMapper.mapToPostDTO(e, comments)) //
        .collect(Collectors.toList());
  }

  @Override
  public ApiResp<PostEntity> addPost(Long userId, String title, String body) {

    PostEntity post = postService.savePostByUserId(userId, title, body);
    return ApiResp.<PostEntity>builder() //
        .ok() //
        .data(List.of(post)) //
        .build();

  }

  @Override
  public ApiResp<PostEntity> deletePost(Long postId) {
    PostEntity post = postService.deletePost(postId);
    return ApiResp.<PostEntity>builder() //
        .ok() //
        .data(List.of(post)) //
        .build();
  }
}
