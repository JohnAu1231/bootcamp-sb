package com.bootcamp.sp.democalculatorsb.controller;

import java.time.LocalDate;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.sp.democalculatorsb.model.Book;

public interface BookOperation {
  
  @GetMapping(value = "/books")
  public Book getBook(@RequestParam String author);

  @GetMapping(value = "/books/date")
  public LocalDate getDate(@RequestParam String author);

}

