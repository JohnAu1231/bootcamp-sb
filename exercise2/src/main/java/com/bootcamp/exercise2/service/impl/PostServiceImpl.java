package com.bootcamp.exercise2.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.event.spi.PostCommitUpdateEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.exercise2.entity.PostEntity;
import com.bootcamp.exercise2.entity.UserEntity;
import com.bootcamp.exercise2.infra.Scheme;
import com.bootcamp.exercise2.model.mapper.PostEntityMapper;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO;
import com.bootcamp.exercise2.respository.PostRespository;
import com.bootcamp.exercise2.service.PostService;
import com.bootcamp.exercise2.service.UserService;

@Service
public class PostServiceImpl implements PostService {

  @Value(value = "${api.json-place-holder.domain}")
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.posts}")
  private String postsEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private PostRespository postRespository;

  @Autowired
  private PostEntityMapper postEntityMapper;

  @Autowired
  private UserService userService;

  @Override
  public List<ExPostDTO> getPosts() {

    String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowercase()) //
        .host(this.domain) //
        .path(this.postsEndpoint) //
        .toUriString(); //
    ExPostDTO[] posts = restTemplate.getForObject(url, ExPostDTO[].class);

    return Arrays.asList(posts);

  }

  @Override
  public List<PostEntity> getPostsFromDB() {
    return postRespository.findAll();
  }

  @Override
  public void savePosts() {
    List<PostEntity> posts = this.getPosts().stream() //
        .map(p -> {
          List<UserEntity> users = userService.getUsersFromDB().stream() //
              .filter(e -> e.getId() == p.getUserId()) //
              .collect(Collectors.toList());
          PostEntity post = postEntityMapper.mapToPostEntity(p);
          if (!users.isEmpty()) {
            post.setUser(users.get(0));
          }
          return post;
        }).collect(Collectors.toList());
    postRespository.saveAll(posts);
  }

  public List<PostEntity> getPostById(Long userId) {
    return userService.getUser(userId).getPosts();
  }

  public PostEntity savePostByUserId(Long userId, String title, String body) {
    PostEntity post = PostEntity.builder() //
        .body(body) //
        .title(title) //
        .user(userService.getUser(userId)) //
        .build();
    postRespository.save(post);
    return post;
  }

  public PostEntity deletePost(Long postId) {
    PostEntity post = postRespository.findById(postId).get();
    postRespository.deleteById(postId);
    return post;
  }
}
