package com.bootcamp.sp.democalculatorsb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface DatabaseOperation {
  @GetMapping(value = "/database/value")
  public String getNumOfArr(@RequestParam String index);

  @GetMapping(value = "/database/sorting")
  public void sort();

  @GetMapping(value = "/database/array")
  public String getArr();

  @GetMapping(value = "/database/map")
  public String addMap(@RequestParam String str, @RequestParam String num);

  @GetMapping(value = "/database/map/value")
  public String getMap(@RequestParam String key);
}
