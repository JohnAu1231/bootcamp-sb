package com.bootcamp.demo_dto_sb.dto.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.bootcamp.demo_dto_sb.dto.StockDTO;
import com.bootcamp.demo_dto_sb.model.Stock;

@Component
// @ Controller : work with @GetMapping, @PostMapping, etc
// @ Service: just representing the class is a servic layer
// @Configuration: always used in some classes in the config folder
// @Repository: connect to the DB by JPA framework
public class StockMapper {
  
  public StockDTO mapToStockDTO(Stock stock) {
    return StockDTO.builder() //
          .stockNo(stock.getId()) //
          .quantity(stock.getQuantity()) //
          .build();
  }
}
