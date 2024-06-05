package com.bootcamp.exercise2.model.reqDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExPostDTO {
  int userId;
  int id;
  String title;
  String body;
}
