package com.bootcamp.demo_dto_sb.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.demo_dto_sb.dto.StockDTO;
import com.bootcamp.demo_dto_sb.infra.NotFoundException;
import com.bootcamp.demo_dto_sb.model.Stock;
import com.bootcamp.demo_dto_sb.model.User;

public interface StockOperation {
  
  @GetMapping(value = "/stocks")
  @ResponseStatus(value = HttpStatus.OK)
  public List<StockDTO> getStocks();

  @GetMapping(value = "/stock")
  @ResponseStatus(value = HttpStatus.OK)
  Stock getStockById(@RequestParam String id) throws NotFoundException;

  @PostMapping(value = "/stock")
  @ResponseStatus(value = HttpStatus.OK)
  Stock saveStock(@RequestBody Stock stock, @RequestParam int userId);

  @GetMapping(value = "test/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<Stock> demoResponseEntity(@PathVariable String id);
}
