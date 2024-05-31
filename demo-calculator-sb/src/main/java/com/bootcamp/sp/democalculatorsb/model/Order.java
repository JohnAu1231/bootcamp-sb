package com.bootcamp.sp.democalculatorsb.model;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {
  private int id;
  private List<String> address;
}
