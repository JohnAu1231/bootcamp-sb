package com.bootcamp.exercise2.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.exercise2.entity.CommentEntity;
import com.bootcamp.exercise2.entity.PostEntity;
import com.bootcamp.exercise2.infra.Scheme;
import com.bootcamp.exercise2.model.mapper.CommentEntityMapper;
import com.bootcamp.exercise2.model.reqDto.ExCommentDTO;
import com.bootcamp.exercise2.respository.CommentRespository;
import com.bootcamp.exercise2.respository.PostRespository;
import com.bootcamp.exercise2.service.CommentService;
import com.bootcamp.exercise2.service.PostService;

@Service
public class CommentServiceImpl implements CommentService {

  @Value(value = "${api.json-place-holder.domain}")
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.comments}")
  private String commentsEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private CommentRespository commentRespository;

  @Autowired
  private CommentEntityMapper commentEntityMapper;

  @Autowired
  private PostService postService;

  @Autowired
  private PostRespository postRespository;

  @Override
  public List<ExCommentDTO> getComments() {

    String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowercase()) //
        .host(this.domain) //
        .path(this.commentsEndpoint) //
        .toUriString(); //
    ExCommentDTO[] comments =
        restTemplate.getForObject(url, ExCommentDTO[].class);
    return Arrays.asList(comments);
  }

  @Override
  public CommentEntity saveComment(CommentEntity comment) {
    return commentRespository.save(comment);
  }

  @Override
  public List<CommentEntity> getCommentsFromDB() {
    return commentRespository.findAll();
  }

  @Override
  public List<CommentEntity> getCommentsByUserIdFromDB(Long id) {
    List<Long> postIds = postService.getPostById(id).stream() //
        .map(e -> e.getId()) //
        .collect(Collectors.toList());
    List<CommentEntity> ls = new ArrayList<>();
    postIds.stream() //
        .map(e -> commentRespository.findByPostId(e)) //
        .forEach(e -> e.stream().forEach(f -> ls.add(f)));
    return ls;
  }

  @Override
  public void saveComments() {
    List<CommentEntity> comments = this.getComments().stream() //
        .map(c -> {
          List<PostEntity> posts = postService.getPostsFromDB().stream() //
              .filter(e -> e.getId() == c.getPostId()) //
              .collect(Collectors.toList());
          CommentEntity comment = commentEntityMapper.mapToCommentEntity(c); //
          if (!posts.isEmpty())
            comment.setPost(posts.get(0));
          return comment;
        }).collect(Collectors.toList()); //
    commentRespository.saveAll(comments);
  }

  @Override
  public List<CommentEntity> getCommentsByPostId(Long postId) {
    List<CommentEntity> comments = commentRespository.findByPostId(postId);
    return comments;
  }

  @Override
  public CommentEntity addComment(Long postId, String name, String body,
      String email) {
    CommentEntity comment = CommentEntity.builder() //
        .body(body) //
        .email(email) //
        .name(name) //
        .post(postRespository.findById(postId).get()) //
        .build();
    commentRespository.save(comment);
    return comment;
  }

  @Override
  public CommentEntity updateComment(Long commentId, String name, String body,
  String email) {
    CommentEntity comment = CommentEntity.builder() //
    .body(body) //
    .email(email) //
    .name(name) //
    .id(commentId)//
    .build();
    commentRespository.save(comment);
    return comment;
  }
}
