package com.bootcamp.exercise_calculator.service.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.bootcamp.exercise_calculator.exceptions.InvaildResponse;
import com.bootcamp.exercise_calculator.infra.SysCode;
import com.bootcamp.exercise_calculator.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService{
  

  public String get(String x, String y, String operation) {
    double a;
    double b;
      a = Double.parseDouble(x);
      b = Double.parseDouble(y);
      
    return switch (operation) {
      case "sum" -> BigDecimal.valueOf(a).add(BigDecimal.valueOf(b)).toString();
      case "mul" -> BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b))
          .toString();
      case "sub" -> BigDecimal.valueOf(a).subtract(BigDecimal.valueOf(b))
          .toString();
      case "div" -> 
        // if (b == 0) {
        //   throw new IllegalArgumentException("Cant divide by 0");
        // } yield
         BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b)).setScale(5).toString();
      
      // default -> "operation should be sum,mul,div or sub";
      default ->  {
        throw new InvaildResponse(SysCode.INVAILD_OPERATION);
      }
    };
  }
}
