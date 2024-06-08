package com.bootcamp.exercise2.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.exercise2.controller.PostOperation;
import com.bootcamp.exercise2.entity.PostEntity;
import com.bootcamp.exercise2.entity.UserEntity;
import com.bootcamp.exercise2.model.mapper.PostEntityMapper;
import com.bootcamp.exercise2.model.mapper.UserEntityMapper;
import com.bootcamp.exercise2.model.mapper.UserMapper;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.reqDto.ExUserDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO;
import com.bootcamp.exercise2.respository.PostRespository;
import com.bootcamp.exercise2.service.PostService;
import com.bootcamp.exercise2.service.UserService;

@RestController
public class PostController implements PostOperation {

  @Autowired
  private PostService postService;

  @Autowired
  private PostEntityMapper postEntityMapper;

  @Autowired
  private PostRespository postRespository;

  @Autowired
  private UserService userService;

  @Autowired
  private UserEntityMapper userEntityMapper;

  @Override
  public List<ExPostDTO> getPosts() {
    return postService.getPosts();
  }

  @Override
  public void savePosts() {
    List<PostEntity> postList = postService.getPosts().stream() //
        .map(p -> {

          List<UserEntity> userList = userService.getUsersFromDB().stream() //
              .filter(e -> e.getId() == p.getUserId()) //
              .collect(Collectors.toList());
          PostEntity f = postEntityMapper.mapToPostEntity(p);
          if (!userList.isEmpty()) {

            f.setUser(userList.get(0));
          }
          return f;
        })
        //
        .collect(Collectors.toList());
    postRespository.saveAll(postList);
  }

  @Override
  public List<PostDTO> getPostsFromDB() {
    return postService.getPostsFromDB().stream() //
        .map(e -> postEntityMapper.mapToPostDTO(e)) //
        .collect(Collectors.toList());
  }
}
