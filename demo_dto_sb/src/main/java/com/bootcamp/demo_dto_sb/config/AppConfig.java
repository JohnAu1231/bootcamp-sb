package com.bootcamp.demo_dto_sb.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.bootcamp.demo_dto_sb.dto.mapper.StockMapper;
import com.bootcamp.demo_dto_sb.model.Stock;
import com.bootcamp.demo_dto_sb.model.User;
import jakarta.annotation.PostConstruct;
import lombok.Getter;

@Configuration
@Getter
public class AppConfig {
  // public static final List<User> users = new ArrayList<>();

  private final List<User> users = new ArrayList<>();

  public List<User> getUsers() {
    return this.users;
  }

  @Bean
  Stock geStock() {
    return new Stock(999, "", 250);
  }

  // @Bean
  // StockMapper stockMapper() {
  //   return new StockMapper();
  // }

  @PostConstruct // Rigth after creating bookController bean befroe server start completed
  public void init() {
  
    User userA = new User();
    userA.add(new Stock(5, "AAA", 1000));
    User userB = new User();
    userB.add(new Stock(5, "BBB", 20000));
    User userC = new User();
    userC.add(new Stock(10, "CCC", 200));
    users.add(userA);
    users.add(userB);
    users.add(userC);
  }

  public void add(User user) {
    this.users.add(user);
  }
}
