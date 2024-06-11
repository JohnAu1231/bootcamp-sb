package com.bootcamp.exercise2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.exercise2.entity.CommentEntity;
import com.bootcamp.exercise2.infra.ApiResp;
import com.bootcamp.exercise2.model.respDto.CommentWithoutIdDTO;
import com.bootcamp.exercise2.model.respDto.UserWithCommentDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO.CommentDTO;

public interface CommentOperation {
  
    @GetMapping(value = "/commentbyapi")
  UserWithCommentDTO getCommentById(@RequestParam Long id);

  @GetMapping(value = "/comment")
  ApiResp<CommentDTO> getCommentsByIdFromDB(@RequestParam Long userId);

@GetMapping(value = "/comment/{postId}")
ApiResp<CommentDTO> getCommentByPostId(@PathVariable Long postId);

  List<CommentDTO> getComments();

  @GetMapping(value = "/comments")
  ApiResp<CommentDTO> getCommentsFromDB();

  void saveComments();

  @PostMapping(value = "/comment")
  ApiResp<CommentDTO> addComment(@RequestParam Long postId, @RequestParam String name, @RequestParam String body, @RequestParam String email);

  @PatchMapping(value = "/comment")
  ApiResp<CommentDTO> updateComment(@RequestParam Long commentId, @RequestParam String name, @RequestParam String body, @RequestParam String email);
}
