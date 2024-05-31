package com.bootcamp.sp.democalculatorsb.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.sp.democalculatorsb.controller.BookOperation;
import com.bootcamp.sp.democalculatorsb.model.Book;
import com.bootcamp.sp.democalculatorsb.service.BookService;
import jakarta.annotation.PostConstruct;

@Service // = bean
public class BookServiceImpl implements BookService{
  
  private final Map<Long, Book> bookMap = new HashMap<>();

  public Map<Long, Book> getBookMap() {
    return this.bookMap;
  }

  @PostConstruct // Rigth after creating bookController bean befroe server start completed
  public void init() {
    Book book1 = new Book("Jenny", LocalDate.of(2000, 10 , 1));
    Book book2 = new Book("John", LocalDate.of(2001, 10 , 1));
    Book book3 = new Book("Joe", LocalDate.of(2002, 10 , 1));
    bookMap.put(book1.getId(), book1);
    bookMap.put(book1.getId(), book2);
    bookMap.put(book1.getId(), book3);
  }

  @Override
  public Book getBook(String author) {
    if (author == null)
      return null;
    // return new Book("Sally Chan", LocalDate.of(2000, 10, 3));
    return this.bookMap.values().stream() // 
                      .filter(e -> e.getAuthor().equals(author)) //
                      .findFirst()  //
                      .orElse(null);
  }
}
