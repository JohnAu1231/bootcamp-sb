package com.bootcamp.exercise2.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.exercise2.controller.CommentOperation;
import com.bootcamp.exercise2.infra.ApiResp;
import com.bootcamp.exercise2.infra.NotFoundException;
import com.bootcamp.exercise2.model.mapper.CommentEntityMapper;
import com.bootcamp.exercise2.model.mapper.UserMapper;
import com.bootcamp.exercise2.model.respDto.CommentWithoutIdDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO;
import com.bootcamp.exercise2.model.respDto.UserWithCommentDTO;
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

  // @Override
  // public UserWithCommentDTO getCommentById(int id) {
  //   userService.getComments();
  //   userService.getPosts();
  //   List<UserDTO> ls = userService.getUsers().stream() //
  //       .map(e -> userMapper.mapToUserDTO(e)) //
  //       .filter(e -> e.getId() == id) //
  //       .collect(Collectors.toList()); //
  //   if (ls.size() == 0)
  //     throw new NotFoundException();
  //   // List<CommentWithoutIdDTO> result = new ArrayList<>();

  //   // for (int i = 0; i < ls.size(); i++) {
  //   //   for (int j = 0; j < ls.get(i).getPosts().size(); j++) {
  //   //     for (int k = 0; k < ls.get(i).getPosts().get(j).getComments()
  //   //         .size(); k++) {
  //   //       result.add(userMapper.mapToCommentWithoutIdDTO(
  //   //           ls.get(i).getPosts().get(j).getComments().get(k)));
  //   //     }
  //   //   }
  //   // }

  //  List<CommentWithoutIdDTO> comments = ls.stream()
  //   .flatMap(l -> l.getPosts().stream())
  //   .flatMap(p -> p.getComments().stream())
  //   .map(c -> userMapper.mapToCommentWithoutIdDTO(c))
  //   .collect(Collectors.toList());

  //   return userMapper.mapToUserWithCommentDTO(ls.get(0), comments);
  // }

  @Override
  public UserWithCommentDTO getCommentById(int id) {
    List<UserDTO> ls = userService.getUsers().stream() //
        .map(e -> userMapper.mapToUserDTO(e, postService.getPosts(),   commentService.getComments())) //
        .filter(e -> e.getId() == id) //
        .collect(Collectors.toList()); //
    if (ls.size() == 0)
      throw new NotFoundException();

   List<CommentWithoutIdDTO> comments = ls.stream()
    .flatMap(l -> l.getPosts().stream())
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
   commentService.getComments().stream() //
    .map(e -> commentEntityMapper.mapToCommentEntity(e)) //
    .forEach(e -> commentRespository.save(e));
  }

  @Override
  public ApiResp<CommentDTO> getCommentsByIdFromDB(Long postid) {
   List<CommentDTO> ls = commentService.getCommentsByUserIdFromDB(postid).stream() //
    .map(e -> commentEntityMapper.mapToCommentDTO(e)) //
    .collect(Collectors.toList());
    System.out.println(ls.toString());
    return ApiResp.<CommentDTO>builder() //
          .ok() //
          .data(ls) //
          .build();
  }


}
