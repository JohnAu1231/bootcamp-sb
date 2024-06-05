package com.bootcamp.exercise2.Controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.exercise2.Controller.CommentOperation;
import com.bootcamp.exercise2.infra.NotFoundException;
import com.bootcamp.exercise2.model.mapper.UserMapper;
import com.bootcamp.exercise2.model.respDto.CommentWithoutIdDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO;
import com.bootcamp.exercise2.model.respDto.UserWithCommentDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO.CommentDTO;
import com.bootcamp.exercise2.service.UserService;

@RestController
public class CommentController implements CommentOperation {
  @Autowired
  private UserService userService;

  @Autowired
  private UserMapper userMapper;

  @Override
  public UserWithCommentDTO getCommentById(int id) {
    userService.getComments();
    userService.getPosts();
    List<UserDTO> ls = userService.getUsers().stream() //
        .map(e -> userMapper.mapToUserDTO(e)) //
        .filter(e -> e.getId() == id) //
        .collect(Collectors.toList()); //
    if (ls.size() == 0)
      throw new NotFoundException();
    // List<CommentWithoutIdDTO> result = new ArrayList<>();

    // for (int i = 0; i < ls.size(); i++) {
    //   for (int j = 0; j < ls.get(i).getPosts().size(); j++) {
    //     for (int k = 0; k < ls.get(i).getPosts().get(j).getComments()
    //         .size(); k++) {
    //       result.add(userMapper.mapToCommentWithoutIdDTO(
    //           ls.get(i).getPosts().get(j).getComments().get(k)));
    //     }
    //   }
    // }

   List<CommentWithoutIdDTO> comments = ls.stream()
    .flatMap(l -> l.getPosts().stream())
    .flatMap(p -> p.getComments().stream())
    .map(c -> userMapper.mapToCommentWithoutIdDTO(c))
    .collect(Collectors.toList());

    return userMapper.mapToUserWithCommentDTO(ls.get(0), comments);

  }

  @Override
  public List<CommentDTO> getComments() {
    return userService.getComments().stream() //
        .map(e -> userMapper.mapToCommentDTO(e)) //
        .collect(Collectors.toList());
  }

}
