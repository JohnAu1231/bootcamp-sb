package com.bootcamp.exercise2.service;

import java.util.List;
import com.bootcamp.exercise2.entity.CommentEntity;
import com.bootcamp.exercise2.model.reqDto.ExCommentDTO;

public interface CommentService {
  
  CommentEntity saveComment(CommentEntity comment);

  List<ExCommentDTO> getComments();

  List<CommentEntity> getCommentsFromDB();

  List<CommentEntity> getCommentsByUserIdFromDB(Long id);
}
