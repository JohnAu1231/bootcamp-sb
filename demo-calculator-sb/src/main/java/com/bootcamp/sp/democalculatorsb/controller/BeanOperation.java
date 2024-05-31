package com.bootcamp.sp.democalculatorsb.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface BeanOperation {
  
  @GetMapping(value = "/beans")
  String[] getBeans();
}
