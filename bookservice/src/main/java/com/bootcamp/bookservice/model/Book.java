package com.bootcamp.bookservice.model;

import lombok.Getter;

@Getter
public class Book {
  
  private int BookID;

  private String bookName;

  public Book(String bookName) {

    this.BookID++;

    this.bookName = bookName;
  }
}
