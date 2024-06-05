package com.bootcamp.exercise2.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.exercise2.model.respDto.CommentWithoutIdDTO;
import com.bootcamp.exercise2.model.respDto.UserWithCommentDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO.CommentDTO;

public interface CommentOperation {
  
    @GetMapping(value = "/commentbyid")
  UserWithCommentDTO getCommentById(@RequestParam int id);

  @GetMapping(value = "/comments")
  List<CommentDTO> getComments();

}
