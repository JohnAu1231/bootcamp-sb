package com.bootcamp.demo_restful.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo_restful.entity.UserEntity;
import com.bootcamp.demo_restful.repository.UserRespository;

@Component
public class AppRunner implements CommandLineRunner{

  // AppRunner bean already exists in Context after server start
  @Autowired
  private UserRespository userRespository;
  // run() will be executed by Spring before completed server start process
  @Override
  public void run(String... args) {
    userRespository.save(new UserEntity());
  }
  
}
