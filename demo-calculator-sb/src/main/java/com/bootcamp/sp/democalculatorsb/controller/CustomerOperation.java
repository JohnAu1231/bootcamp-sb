package com.bootcamp.sp.democalculatorsb.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.sp.democalculatorsb.model.Customer;

public interface CustomerOperation {
  
  @GetMapping(value = "/customers")
  List<Customer> getAll();
}
