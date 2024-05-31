package com.bootcamp.sp.democalculatorsb.service;

import java.util.Map;
import com.bootcamp.sp.democalculatorsb.model.Book;

public interface BookService {
  
  Book getBook(String author);

  public Map<Long, Book> getBookMap();
}
