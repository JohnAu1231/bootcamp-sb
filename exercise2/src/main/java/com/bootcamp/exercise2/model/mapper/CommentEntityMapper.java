package com.bootcamp.exercise2.model.mapper;

import javax.xml.stream.events.Comment;
import org.springframework.stereotype.Component;
import com.bootcamp.exercise2.entity.CommentEntity;
import com.bootcamp.exercise2.model.reqDto.ExCommentDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO.CommentDTO;
import lombok.NonNull;

@Component
public class CommentEntityMapper {
  
  public CommentEntity mapToCommentEntity(ExCommentDTO comment) {

    if(comment == null) 
      return null;
    return CommentEntity.builder() //
            .body(comment.getBody()) //
            .email(comment.getEmail()) //
            .id(comment.getId()) //
            // .postId(comment.getPostId()) //
            .name(comment.getName()) //
            .build();
  }

    public CommentDTO mapToCommentDTO(@NonNull CommentEntity comment) {
    
    return CommentDTO.builder() //
        .body(comment.getBody()) //
        .email(comment.getEmail()) //
        .id(comment.getId()) //
        .name(comment.getName()) //
        .build();
  }
}
