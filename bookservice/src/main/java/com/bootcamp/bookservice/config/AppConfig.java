package com.bootcamp.bookservice.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Configuration;
import com.bootcamp.bookservice.model.Book;
import com.bootcamp.bookservice.model.User;
import jakarta.annotation.PostConstruct;
import lombok.Getter;

@Configuration
@Getter
public class AppConfig {
  
  private final List<User> users = new ArrayList<>();
  private final List<Book> books = new ArrayList<>();

  public void add(User user) {
    this.users.add(user);
  }

  public void add(Book book) {
    this.books.add(book);
  }

  public Book add(String bookName) {
    Book book = new Book(bookName);
    books.add(book);
    return book;
  }

  public Optional<Book> getBookByName(String bookName) {
    return books.stream() //
          .filter(e -> e.getBookName().equals(bookName)) //
          .findFirst();
  }

  public List<Book> getBookList() {
    return this.books;
  }

  @PostConstruct
  private void init() {
    this.books.add(new Book("HarryPorter"));
    this.books.add(new Book("HelloKitty"));

    this.users.add(new User("Dorothy"));
  }
}
