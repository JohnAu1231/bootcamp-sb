package com.bootcamp.exercise2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.exercise2.infra.ApiResp;
import com.bootcamp.exercise2.model.respDto.CommentWithoutIdDTO;
import com.bootcamp.exercise2.model.respDto.UserWithCommentDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO.CommentDTO;

public interface CommentOperation {
  
    @GetMapping(value = "/commentbyid")
  UserWithCommentDTO getCommentById(@RequestParam int id);


  List<CommentDTO> getComments();

  @GetMapping(value = "/comments")
  ApiResp<CommentDTO> getCommentsFromDB();

  void saveComments();

  @GetMapping(value = "/comment")
  ApiResp<CommentDTO> getCommentsByIdFromDB(@RequestParam Long postid);

}
