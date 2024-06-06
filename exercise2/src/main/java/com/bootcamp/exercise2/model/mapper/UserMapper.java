package com.bootcamp.exercise2.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
import lombok.NonNull;

@Component
public class UserMapper {

  // @Autowired
  // private Map<Integer, ExUserDTO> usersBean;

  // @Autowired
  // private MultiValueMap<Integer, ExPostDTO> postsBean;

  // @Autowired
  // private MultiValueMap<Integer, ExCommentDTO> commentsBean;

  public UserDTO mapToUserDTO(ExUserDTO user, List<ExPostDTO> posts,
      List<ExCommentDTO> comments) {
    if (user == null)
      return null;

    List<PostDTO> ls = null;
    if (posts != null) {
      ls = posts.stream() //
          .filter(e -> e.getUserId() == user.getId()) //
          .map(e -> mapToPostDTO(e, comments)) //
          .collect(Collectors.toList());
    }
    UserDTO.Address userAddress = null;
    if (user.getAddress() != null) {
      UserDTO.Address.Geo userAddressGeo = null;
      if (user.getAddress().getGeo() != null) {
        userAddressGeo = UserDTO.Address.Geo.builder() //
            .latitude(user.getAddress().getGeo().getLatitude())//
            .longtitude(user.getAddress().getGeo().getLongtitude()).build();
      }
      userAddress = UserDTO.Address.builder() //
          .street(user.getAddress().getStreet()) //
          .suite(user.getAddress().getSuite()) //
          .city(user.getAddress().getCity()) //
          .zipcode(user.getAddress().getZipcode()) //
          .geo(userAddressGeo) //
          .build();
    }
    UserDTO.Company userCompany = null;
    if (user.getCompany() != null) {
      userCompany = UserDTO.Company.builder() //
          .name(user.getCompany().getName()) //
          .business(user.getCompany().getBusiness()) //
          .catchPhrase(user.getCompany().getCatchPhrase()) //
          .build();
    }
    UserDTO result = UserDTO.builder() //
        .name(user.getName()) //
        .username(user.getUsername()) //
        .phone(user.getPhone()) //
        .email(user.getEmail()) //
        .website(user.getWebsite()) //
        .id(user.getId()) //
        .address(userAddress) //
        .company(userCompany) //
        .posts(ls) //
        .build();

    return result;
  }

  public PostDTO mapToPostDTO(ExPostDTO post, List<ExCommentDTO> comments) {

    if (post == null)
      return null;
    List<CommentDTO> ls = null;
    if (comments != null) {
      ls = comments.stream() //
          .filter(e -> e.getPostId() == post.getId())
          .map(e -> mapToCommentDTO(e)) //
          .collect(Collectors.toList());
    }
    return PostDTO.builder()//
        .body(post.getBody()) //
        .id(post.getId()) //
        .title(post.getTitle()) //
        .comments(ls) //
        .build();
  }

  public CommentDTO mapToCommentDTO(@NonNull ExCommentDTO comment) {
    
    return CommentDTO.builder() //
        .body(comment.getBody()) //
        .email(comment.getEmail()) //
        .id(comment.getId()) //
        .name(comment.getName()) //
        .build();
  }

  public CommentWithoutIdDTO mapToCommentWithoutIdDTO(CommentDTO comment) {
      if(comment == null)
        return null;
    return CommentWithoutIdDTO.builder() //
        .body(comment.getBody()) //
        .email(comment.getEmail()) //
        .name(comment.getName()) //
        .build();
  }

  public UserWithCommentDTO mapToUserWithCommentDTO(UserDTO user,
      List<CommentWithoutIdDTO> comments) {
        List<CommentWithoutIdDTO> ls = null;
        if (comments != null) {
          ls = comments;
        }
    return UserWithCommentDTO.builder() //
        .id(user.getId()) //
        .userName(user.getUsername()) //
        .comments(ls) //
        .build();
  }

}
