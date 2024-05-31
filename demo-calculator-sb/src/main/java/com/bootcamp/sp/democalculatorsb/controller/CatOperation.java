package com.bootcamp.sp.democalculatorsb.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.sp.democalculatorsb.model.Cat;

public interface CatOperation {
  @GetMapping(value = "/cat/test")
  public Cat test();
  
  // API return List<Cat>
  @GetMapping(value = "/cats/test")
  public List<Cat> testCats();

  @GetMapping(value = "/cat/array")
  public Cat[] catArr();
  
}
