package com.bootcamp.exercise2.model.reqDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ExPostDTO {
  Long userId;
  Long id;
  String title;
  String body;
}
