package com.bootcamp.exercise2.service.impl;

import java.util.Arrays;
import java.util.List;
import org.hibernate.event.spi.PostCommitUpdateEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.exercise2.entity.PostEntity;
import com.bootcamp.exercise2.infra.Scheme;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.respository.PostRespository;
import com.bootcamp.exercise2.service.PostService;

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
}
