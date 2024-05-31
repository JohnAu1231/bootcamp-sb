package com.bootcamp.sp.democalculatorsb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface CalculatorOperation {
  @GetMapping(value = "/sum/{x}/{y}")
  public int sum(@PathVariable(value = "x") int salary, 
                @PathVariable(value = "y") int bonus) ;

  @GetMapping(value = "/subtract/{salary}/{bonus}")
  public int subtract(@PathVariable int salary, @PathVariable int bonus) ;

  @GetMapping(value = "/multiply")
  public int multiply(@RequestParam int quantity, @RequestParam int price); 

  @GetMapping(value = "/divide")
  public int divide(@RequestParam int quantity, @RequestParam int price); 

  @GetMapping(value = "/sum/double")
  public String sum2(@RequestParam String q, @RequestParam String p); 
}
