package com.bootcamp.sp.democalculatorsb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.sp.democalculatorsb.model.Cat;

public interface TestOperation {
  
  @GetMapping(value = "/hello")
  public String testSayHello();

  @GetMapping(value = "/hello2")
  public String testSayHello2();

  @GetMapping(value = "/cat") 
  public Cat getWhiteCat();
}
