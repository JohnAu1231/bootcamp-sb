package com.bootcamp.bookservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
  
  private int id;

  private String name;

  public User(String name) {
    this.id++;

    this.name = name;
  }
}
