package com.bootcamp.exercise_calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.exercise_calculator.dto.CalculatorDTO;
import com.bootcamp.exercise_calculator.model.Calculator;


public interface CalculatorOperation {
  
  @GetMapping(value = "/Get")
  public CalculatorDTO get(@RequestParam String x, @RequestParam String y, @RequestParam String operation);
  
  @GetMapping(value = "/Get2/{x}/{y}/{operation}")
  public CalculatorDTO get2(@PathVariable String x, @PathVariable String y, @PathVariable String operation);

  @PostMapping(value = "/Post")
  public String cal(@RequestBody Calculator calculator);
}
