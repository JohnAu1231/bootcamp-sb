package com.bootcamp.demo_restful.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_restful.model.dto.User;

@Configuration
public class AppConfig {
  
  @Bean
  RestTemplate beanRestTemplate() {
    return new RestTemplate();
  }

  @Bean 
  List<User> usersBean() {
    return new ArrayList<>();
  }
  
}
