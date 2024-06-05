package com.bootcamp.exercise2.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import com.bootcamp.exercise2.model.reqDto.ExCommentDTO;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.reqDto.ExUserDTO;
import com.bootcamp.exercise2.model.respDto.CommentWithoutIdDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO;
import com.bootcamp.exercise2.model.respDto.UserWithCommentDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO.CommentDTO;

@Component
public class UserMapper {

  @Autowired
  private Map<Integer, ExUserDTO> usersBean;

  @Autowired
  private MultiValueMap<Integer, ExPostDTO> postsBean;

  @Autowired
  private MultiValueMap<Integer, ExCommentDTO> commentsBean;

  public UserDTO mapToUserDTO(ExUserDTO user) {
    List<PostDTO> ls = new ArrayList<PostDTO>();      
    for (Integer key: postsBean.keySet()) {
      for (ExPostDTO value: postsBean.get(key)) {
      if (key == user.getId()) {
        ls.add(mapToPostDTO(value));
      }
    }
  }

    return UserDTO.builder() //
        .name(user.getName()) //
        .username(user.getUsername()) //
        .phone(user.getPhone()) //
        .email(user.getEmail()) //
        .website(user.getWebsite()) //
        .id(user.getId()) //
        .address(UserDTO.Address.builder() //
            .street(user.getAddress().getStreet()) //
            .suite(user.getAddress().getSuite()) //
            .city(user.getAddress().getCity()) //
            .zipcode(user.getAddress().getZipcode()) //
            .geo(UserDTO.Address.Geo.builder() //
                .latitude(user.getAddress().getGeo().getLatitude())//
                .longtitude(user.getAddress().getGeo().getLongtitude()).build()) //
            .build())
        .company(UserDTO.Company.builder() //
            .name(user.getCompany().getName()) //
            .business(user.getCompany().getBusiness()) //
            .catchPhrase(user.getCompany().getCatchPhrase()) //
            .build()) //
        .posts(ls) //
        .build();
  }

  public PostDTO mapToPostDTO(ExPostDTO post) {
    List<CommentDTO> ls = new ArrayList<CommentDTO>();
    for (Integer key: commentsBean.keySet()) {
      for (ExCommentDTO value: commentsBean.get(key)) {
      if (key == post.getId()) {
        ls.add(mapToCommentDTO(value));
      }
    }
  }
    return PostDTO.builder()//
        .body(post.getBody()) //
        .id(post.getId()) //
        .title(post.getTitle()) //
        .comments(ls) //
        .build();
  }

  public CommentDTO mapToCommentDTO(ExCommentDTO comment) {
    return CommentDTO.builder() //
        .body(comment.getBody()) //
        .email(comment.getEmail()) //
        .id(comment.getId()) //
        .name(comment.getName()) //
        .build();
  }

  public CommentWithoutIdDTO mapToCommentWithoutIdDTO(CommentDTO comment) {
    return CommentWithoutIdDTO.builder() //
        .body(comment.getBody()) //
        .email(comment.getEmail()) //
        .name(comment.getName()) //
        .build();
  }

  public UserWithCommentDTO mapToUserWithCommentDTO(UserDTO user, List<CommentWithoutIdDTO> comments) {
    return UserWithCommentDTO.builder() //
            .id(user.getId()) //
            .userName(user.getUsername()) //
            .comments(comments) //
            .build();
  }

}
