package com.bootcamp.exercise2.service.impl;

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
import com.bootcamp.exercise2.infra.Scheme;
import com.bootcamp.exercise2.model.mapper.CommentEntityMapper;
import com.bootcamp.exercise2.model.reqDto.ExCommentDTO;
import com.bootcamp.exercise2.respository.CommentRespository;
import com.bootcamp.exercise2.respository.PostRespository;
import com.bootcamp.exercise2.service.CommentService;

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
  public CommentEntity saveComment(CommentEntity comment){
    return commentRespository.save(comment);
  }

  @Override
  public List<CommentEntity> getCommentsFromDB() {
    return commentRespository.findAll();
  }

  @Override
  public List<CommentEntity> getCommentsByUserIdFromDB(Long id) {
    return commentRespository.findByPostId(id);
  }

}
