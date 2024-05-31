package com.bootcamp.bookservice.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.bookservice.config.AppConfig;
import com.bootcamp.bookservice.model.Book;
import com.bootcamp.bookservice.service.BookService;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private AppConfig appconfig;
  
  @Override
  public Optional<Book> getBook(String name) {
    return appconfig.getBooks().stream() //
                    .filter(e -> e.getBookName().equals(name)) //
                    .findFirst();
  }

  @Override
  public List<Book> getBookList() {
    return appconfig.getBookList();
  }

  @Override
  public Book addBook(String bookName) {
    return appconfig.add(bookName);
  }
}
