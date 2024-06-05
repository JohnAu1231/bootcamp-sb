package com.bootcamp.exercise2.model.reqDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExCommentDTO {
  int postId;
  int id;
  String name;
  String email;
  String body;
}
