package com.bootcamp.demo_dto_sb.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
  public class Stock {

    private int id;
    private String description;
    private int quantity;
  
  
}
