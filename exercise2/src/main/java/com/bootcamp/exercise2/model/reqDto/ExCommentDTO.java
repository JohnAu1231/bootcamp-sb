package com.bootcamp.exercise2.model.reqDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ExCommentDTO {
  int postId;
  int id;
  String name;
  String email;
  String body;
}
