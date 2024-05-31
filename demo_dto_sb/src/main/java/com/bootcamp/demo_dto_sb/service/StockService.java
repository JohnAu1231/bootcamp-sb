package com.bootcamp.demo_dto_sb.service;

import java.util.List;
import com.bootcamp.demo_dto_sb.exceptions.UserNotFoundException;
import com.bootcamp.demo_dto_sb.infra.NotFoundException;
import com.bootcamp.demo_dto_sb.model.Stock;

public interface StockService {
  
  public List<Stock> getAll();
  public Stock getById(int stockId) throws NotFoundException;
  Stock save(Stock stock, int userID)  ;
}
