package com.bootcamp.sp.democalculatorsb.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.bootcamp.sp.democalculatorsb.model.Cat;
import com.bootcamp.sp.democalculatorsb.model.Color;


@Configuration // new AppConfig() -> Spring Context
public class AppConfig {

  public String sayHello() {
    return "hello"; 
  }

  @Bean (name = "white") 
  Cat createWitheCat() {
    return new Cat("ABC", 3, List.of(Color.WHITE));
  }

  @Bean (name = "red")
  // @Primary //Approach1
  Cat createRedCat() {
    return new Cat("DEF", 4, List.of(Color.RED));
  }
}
