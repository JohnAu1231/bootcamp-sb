package com.bootcamp.bookservice.service;

import java.util.List;
import java.util.Optional;
import com.bootcamp.bookservice.model.Book;

public interface BookService {
  
  public Optional<Book> getBook(String name);

  public List<Book> getBookList();

  public Book addBook(String bookName);

}
