package com.bootcamp.exercise2.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.exercise2.controller.CommentOperation;
import com.bootcamp.exercise2.entity.CommentEntity;
import com.bootcamp.exercise2.entity.PostEntity;
import com.bootcamp.exercise2.infra.ApiResp;
import com.bootcamp.exercise2.infra.NotFoundException;
import com.bootcamp.exercise2.model.mapper.CommentEntityMapper;
import com.bootcamp.exercise2.model.mapper.UserMapper;
import com.bootcamp.exercise2.model.respDto.CommentWithoutIdDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO;
import com.bootcamp.exercise2.model.respDto.UserWithCommentDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO.CommentDTO;
import com.bootcamp.exercise2.respository.CommentRespository;
import com.bootcamp.exercise2.service.CommentService;
import com.bootcamp.exercise2.service.PostService;
import com.bootcamp.exercise2.service.UserService;

@RestController
public class CommentController implements CommentOperation {
  @Autowired
  private CommentService commentService;

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private CommentRespository commentRespository;

  @Autowired
  private CommentEntityMapper commentEntityMapper;

  @Autowired
  private UserMapper userMapper;

  @Override
  public UserWithCommentDTO getCommentById(Long id) {
    List<UserDTO> ls = userService.getUsers().stream() //
        .map(e -> userMapper.mapToUserDTO(e, postService.getPosts(),
            commentService.getComments())) //
        .filter(e -> e.getId() == id) //
        .collect(Collectors.toList()); //
    if (ls.size() == 0)
      throw new NotFoundException();

    List<CommentWithoutIdDTO> comments =
        ls.stream().flatMap(l -> l.getPosts().stream())
            .flatMap(p -> p.getComments().stream())
            .map(c -> userMapper.mapToCommentWithoutIdDTO(c))
            .collect(Collectors.toList());

    return userMapper.mapToUserWithCommentDTO(ls.get(0), comments);

  }

  @Override
  public List<CommentDTO> getComments() {
    return commentService.getComments().stream() //
        .map(e -> userMapper.mapToCommentDTO(e)) //
        .collect(Collectors.toList());
  }

  @Override
  public ApiResp<CommentDTO> getCommentsFromDB() {
    List<CommentDTO> ls = commentService.getCommentsFromDB().stream() //
        .map(e -> commentEntityMapper.mapToCommentDTO(e)) //
        .collect(Collectors.toList()); //
    return ApiResp.<CommentDTO>builder() //
        .ok() //
        .data(ls) //
        .build(); //

  }

  @Override
  public void saveComments() {
    List<CommentEntity> comments = commentService.getComments().stream() //
        .map(c -> {
          List<PostEntity> posts = postService.getPostsFromDB().stream() //
              .filter(e -> e.getId() == c.getPostId()) //
              .collect(Collectors.toList());
          CommentEntity comment = commentEntityMapper.mapToCommentEntity(c); //
          if (!posts.isEmpty())
            comment.setPost(posts.get(0));
          return comment;
        }).collect(Collectors.toList()); //
    commentRespository.saveAll(comments);
  }

  @Override
  public ApiResp<CommentDTO> getCommentsByIdFromDB(Long userId) {
    List<CommentDTO> ls =
        commentService.getCommentsByUserIdFromDB(userId).stream() //
            .map(e -> commentEntityMapper.mapToCommentDTO(e)) //
            .collect(Collectors.toList());
    return ApiResp.<CommentDTO>builder() //
        .ok() //
        .data(ls) //
        .build();
  }

  @Override
  public ApiResp<CommentDTO> getCommentByPostId(Long postId) {
    List<CommentDTO> ls = commentService.getCommentsByPostId(postId).stream() //
        .map(e -> commentEntityMapper.mapToCommentDTO(e)) //
        .collect(Collectors.toList());
    return ApiResp.<CommentDTO>builder() //
        .ok().data(ls) //
        .build();
  }

  @Override
  public ApiResp<CommentDTO> addComment(Long postId, String name, String body,
      String email) {
    CommentDTO comment = commentEntityMapper
        .mapToCommentDTO(commentService.addComment(postId, name, body, email));
    return ApiResp.<CommentDTO>builder() //
        .ok() //
        .data(List.of(comment)) //
        .build(); //
  }

  @Override
  public ApiResp<CommentDTO> updateComment(Long commentId, String name,
      String body, String email) {
    CommentDTO comment = commentEntityMapper.mapToCommentDTO(
        commentService.updateComment(commentId, name, body, email));
    return ApiResp.<CommentDTO>builder() //
        .ok() //
        .data(List.of(comment)) //
        .build();
  }
}
