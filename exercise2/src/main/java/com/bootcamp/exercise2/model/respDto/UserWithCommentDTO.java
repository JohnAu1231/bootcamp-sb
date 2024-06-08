package com.bootcamp.exercise2.model.respDto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UserWithCommentDTO {
  Long id;
  String userName;
  List<CommentWithoutIdDTO> comments;
}
