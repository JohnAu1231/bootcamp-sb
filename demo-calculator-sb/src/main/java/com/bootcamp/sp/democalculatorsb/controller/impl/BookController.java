package com.bootcamp.sp.democalculatorsb.controller.impl;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.sp.democalculatorsb.controller.BookOperation;
import com.bootcamp.sp.democalculatorsb.model.Book;
import com.bootcamp.sp.democalculatorsb.service.BookService;
import jakarta.annotation.PostConstruct;

@RestController // @Controller + @ResponseBody
public class BookController implements BookOperation {


  
  //Controller layer should not contain businees logic
  //for example, this way to "find a book by author" is a business logic

  //Controller call service layer


  @Autowired
  @Qualifier(value = "BookServiceFromDatabaseImpl")
  private BookService bookServiceFromDatabase;

  @Autowired
  @Qualifier(value = "BookServiceFromMemoryImpl")
  private BookService BookServiceFromMemory;

  @Override
  public Book getBook(String author) {
    Book book = bookServiceFromDatabase.getBook(author);
    book.setAuthor("Peter");
    return book;
  }

  @Override
  public LocalDate getDate(String author) {
    return BookServiceFromMemory.getBook(author).getPublishDate();
  }
}
