package com.bootcamp.sp.democalculatorsb.model;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Book {
  
  private static final AtomicLong count = new AtomicLong(0);
  private long id;
  private String author;
  private LocalDate publishDate;

  public Book(String author, LocalDate publishDate) {
    this.id = count.incrementAndGet();
    this.author = author;
    this.publishDate = publishDate;

  }
}
