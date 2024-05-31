package com.bootcamp.demo_dto_sb.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
  private static int count = 0;
  private int id;
  private List<Stock> stocks;

  public User() {
    this.id = ++count;
    this.stocks = new ArrayList<Stock>();
  }



  public boolean add(Stock stock) {
    return this.stocks.add(stock);
  }

}
