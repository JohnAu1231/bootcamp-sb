package com.bootcamp.sp.democalculatorsb.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Customer {
  private String name;
  private LocalDate joinDate;
  private List<Order> orders;
}
