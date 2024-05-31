package com.bootcamp.demo_dto_sb.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo_dto_sb.config.AppConfig;
import com.bootcamp.demo_dto_sb.exceptions.ListAddException;
import com.bootcamp.demo_dto_sb.exceptions.UserNotFoundException;
import com.bootcamp.demo_dto_sb.infra.NotFoundException;
import com.bootcamp.demo_dto_sb.model.Stock;
import com.bootcamp.demo_dto_sb.model.User;
import com.bootcamp.demo_dto_sb.service.StockService;

@Service
public class StockServiceImpl implements StockService{



@Autowired
private AppConfig appConfig;

@Override
public List<Stock> getAll(){
  return appConfig.getUsers().stream() //
        .flatMap(e -> e.getStocks().stream()) //
        .collect(Collectors.toList());
}

@Override
public Stock getById(int stockId) throws NotFoundException {
  return this.getAll().stream() //
        .filter(e -> e.getId() == stockId) //
        .findFirst() //
        .orElseThrow(() -> new NotFoundException());
}

@Override
public Stock save(Stock stock, int userId)  {
  User user = appConfig.getUsers().stream() //
              .filter(e -> userId == e.getId()) //
              .findAny() //
              .orElseThrow(() -> new UserNotFoundException());
  if(user.add(stock))
    return stock;
  throw new ListAddException();

}

public Stock demoResponseEntity(String id) {
  if (id.length() == 2)
    return new Stock(1, "ABC", 2000);
  throw new IllegalArgumentException();

}
}
