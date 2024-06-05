package com.bootcamp.exercise2.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.exercise2.model.respDto.UserDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO.CommentDTO;

public interface UserOperation {
  
  @GetMapping(value = "/users")
  List<UserDTO> getUsers();


  
  
}
