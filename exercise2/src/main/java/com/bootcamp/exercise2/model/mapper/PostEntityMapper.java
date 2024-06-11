package com.bootcamp.exercise2.model.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.bootcamp.exercise2.entity.PostEntity;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO.CommentDTO;

@Component
public class PostEntityMapper {
  
  public PostEntity mapToPostEntity(ExPostDTO post) {
    
    if(post == null)
      return null;
    return PostEntity.builder() //
              .id(post.getId()) //
              // .userId(post.getUserId()) //
              .body(post.getBody()) //
              .title(post.getTitle()) //
              .build();
  }

  public PostDTO mapToPostDTO(PostEntity post) {
    
    if(post == null)
      return null;
    return UserDTO.PostDTO.builder() //
              .id(post.getId()) //
              .body(post.getBody()) //
              .title(post.getTitle()) //
              .build();
  }

  public PostDTO mapToPostDTO(PostEntity post, List<CommentDTO> comments) {
    
    if(post == null)
      return null;
    return UserDTO.PostDTO.builder() //
              .id(post.getId()) //
              .body(post.getBody()) //
              .title(post.getTitle()) //
              .comments(comments) //
              .build();
  }
}
