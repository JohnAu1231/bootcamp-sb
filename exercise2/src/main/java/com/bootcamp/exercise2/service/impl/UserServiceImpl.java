package com.bootcamp.exercise2.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.exercise2.infra.Scheme;
import com.bootcamp.exercise2.model.User;
import com.bootcamp.exercise2.model.reqDto.ExCommentDTO;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.reqDto.ExUserDTO;
import com.bootcamp.exercise2.service.UserService;


@Service
public class UserServiceImpl implements UserService {

  @Value(value = "${api.json-place-holder.domain}")
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.users}")
  private String usersEndpoint;

  @Value(value = "${api.json-place-holder.endpoints.posts}")
  private String postsEndpoint;

  @Value(value = "${api.json-place-holder.endpoints.comments}")
  private String commentsEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private Map<Integer, ExUserDTO> usersBean;

  @Autowired
  private MultiValueMap<Integer, ExPostDTO> postsBean;

  @Autowired
  private MultiValueMap<Integer, ExCommentDTO> commentsBean;

  @Override
  public List<ExUserDTO> getUsers() {
    boolean empty = usersBean //
        .isEmpty();
    if (empty) {
      String url = UriComponentsBuilder.newInstance() //
          .scheme(Scheme.HTTPS.lowercase()) //
          .host(this.domain) //
          .path(this.usersEndpoint) //
          .toUriString(); //
      ExUserDTO[] users = restTemplate.getForObject(url, ExUserDTO[].class);
      for (int i = 0; i < users.length; i++) {
        usersBean.put(users[i].getId(), users[i]);
      }
      return Arrays.asList(users);
    } else {
      List<ExUserDTO> ls = new ArrayList<ExUserDTO>();
      for (Map.Entry<Integer, ExUserDTO> entry : usersBean.entrySet()) {
        ls.add(entry.getValue());
      }
      return ls;
    }
  }

  @Override
  public List<ExPostDTO> getPosts() {
    boolean empty = postsBean //
        .isEmpty();
    if (empty) {
      String url = UriComponentsBuilder.newInstance() //
          .scheme(Scheme.HTTPS.lowercase()) //
          .host(this.domain) //
          .path(this.postsEndpoint) //
          .toUriString(); //
      ExPostDTO[] posts = restTemplate.getForObject(url, ExPostDTO[].class);
      for (int i = 0; i < posts.length; i++) {
        postsBean.add(posts[i].getUserId(), posts[i]);
      }
      return Arrays.asList(posts);
    } else {
      List<ExPostDTO> ls = new ArrayList<ExPostDTO>();
      for (Integer key : postsBean.keySet()) {
        for (ExPostDTO value : postsBean.get(key)) {
          ls.add(value);
        }
      }
      return ls;
    }
  }

  @Override
  public List<ExCommentDTO> getComments() {
    boolean empty = commentsBean //
        .isEmpty();
    if (empty) {
      String url = UriComponentsBuilder.newInstance() //
          .scheme(Scheme.HTTPS.lowercase()) //
          .host(this.domain) //
          .path(this.commentsEndpoint) //
          .toUriString(); //
      ExCommentDTO[] comments =
          restTemplate.getForObject(url, ExCommentDTO[].class);
      for (int i = 0; i < comments.length; i++) {
        commentsBean.add(comments[i].getPostId(), comments[i]);
      }
      return Arrays.asList(comments);
    } else {
      List<ExCommentDTO> ls = new ArrayList<ExCommentDTO>();
      for (Integer key : commentsBean.keySet()) {
        for (ExCommentDTO value : commentsBean.get(key)) {
          ls.add(value);
        }
      }
      return ls;
    }
  }
}
