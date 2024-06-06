package com.bootcamp.exercise2.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.exercise2.model.reqDto.ExCommentDTO;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.reqDto.ExUserDTO;

@Configuration
public class AppConfig {
  
  @Bean
  RestTemplate beanRestTemplate() {
    return new RestTemplate();
  }

  // @Bean
  // Map<Integer, ExUserDTO> usersBean() {
  //   return new HashMap<>();
  // }

  // @Bean
  // MultiValueMap<Integer, ExPostDTO> postsBean() {
  //   return new LinkedMultiValueMap<>();
  // }

  // @Bean
  // MultiValueMap<Integer, ExCommentDTO> commentsBean() {
  //   return new LinkedMultiValueMap<>();
  // }
}
