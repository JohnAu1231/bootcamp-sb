package com.bootcamp.demo_dto_sb.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_dto_sb.controller.StockOperation;
import com.bootcamp.demo_dto_sb.dto.StockDTO;
import com.bootcamp.demo_dto_sb.dto.mapper.StockMapper;
import com.bootcamp.demo_dto_sb.infra.NotFoundException;
import com.bootcamp.demo_dto_sb.model.Stock;
import com.bootcamp.demo_dto_sb.model.User;
import com.bootcamp.demo_dto_sb.service.StockService;
import com.bootcamp.demo_dto_sb.service.impl.StockServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class StockController implements StockOperation {


  @Autowired
  private StockService stockService;

  @Autowired
  private StockMapper stockMapper;

  public List<StockDTO> getStocks() {
    return stockService.getAll().stream() //
    .collect(Collectors.groupingBy(e -> e.getId(),
        Collectors.summingInt(e -> e.getQuantity()))) // Map.class
    .entrySet().stream() //
    .map(entry -> new Stock(entry.getKey(), null, entry.getValue())) //
    .collect(Collectors.toList()) //
    .stream() //
    .map(s -> stockMapper.mapToStockDTO(s)) //
    .collect(Collectors.toList());

    /* 
    return stockService.getAll().stream() //
        .collect(Collectors.groupingBy(e -> e.getId(),
            Collectors.summingInt(e -> e.getQuantity()))) // Map.class
        .entrySet().stream() //
        .map(e -> StockMapper.mapToStockDTO(new Stock(e.getKey(), null, e.getValue())))
        .collect(Collectors.toList());
    */

    // return StockServiceImpl.getAll().stream() //
    // .map(e -> new StockDTO(e.getId(), e.getQuantity())) //
    // .collect(Collectors.toList());

    // List<Stock> ls = StockServiceImpl.getAll();
    // List<StockDTO> lsD = new ArrayList<>();
    // for (Stock s: ls) {
    // lsD.add(new StockDTO(s.getId(), s.getQuantity()));
    // }
    // return lsD;
    // }
    // User A -> Stock 5 (1000)
    // User B --> 5 (20000)
    // C --> 10 (200)

    // @PostCOnstructor

    // API return

    // [{"stockNo" : 5, "quantity" : 21000},{"stockNo" : 10, "quantity" : 200}]
  }

  @Override
  public Stock getStockById(String id) throws NotFoundException {
    // try {
    int stockId = Integer.parseInt(id);
    Stock stock = stockService.getById(stockId);
    // } catch (NotFoundException e) {
    // } catch (NumberFormatException e) {
    // }
    return stock;
  }

  @Override
  public Stock saveStock(Stock stock, int userId) {
    return stockService.save(stock, userId);
  }

  // Demo ResponseEntity<>
  @GetMapping(value = "test/{id}")
  public ResponseEntity<Stock> demoResponseEntity(@PathVariable String id) {
    Stock stock = null;
    try {
      stock = new StockServiceImpl().demoResponseEntity(id);
      return ResponseEntity.ok().body(stock);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(new Stock(99, "ZZZ", 0)); // 400
    }
  }
}
