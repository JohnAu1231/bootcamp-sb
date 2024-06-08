package com.bootcamp.exercise2.model.reqDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ExCommentDTO {
  Long postId;
  Long id;
  String name;
  String email;
  String body;
}
