package com.bootcamp.bookservice.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bootcamp.bookservice.model.Book;

public interface BookManagementOperation {

  @GetMapping(value = "getBook/{bookName}")
  public Optional<Book> getBook(@PathVariable String bookName);

  
  public List<Book> getBookList();

  public Book addBook(String bookName);
}