package com.bootcamp.exercise2.model.respDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CommentWithoutIdDTO {

      String name;
      String email;
      String body;

}
