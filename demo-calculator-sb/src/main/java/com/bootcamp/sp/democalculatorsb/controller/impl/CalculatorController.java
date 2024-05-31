package com.bootcamp.sp.democalculatorsb.controller.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sp.democalculatorsb.controller.CalculatorOperation;


@Controller
@ResponseBody
public class CalculatorController implements CalculatorOperation {
  

  // @PathVariable is a way to map the variables int the URI to java method input parameters
  @Override
  public int sum(int salary, //
                int bonus) {
          return salary + bonus;
    // int result =  salary + bonus;
    // return String.valueOf(result);
  }

  //We can achieve default mapping by name,
  //if you do not explicitly define PathVariable value
  @Override
  public int subtract(int salary, int bonus) {
    return salary - bonus;
}
  @Override
  public int multiply(int quantity,
            int price) {
              return quantity * price;
            }

  @Override
  public int divide(int quantity,
  int price) {
    return quantity / price;
  }

  @Override
  public String sum2(String q, String p) {

    double p2;
    double q2;
    try {
      p2 = Double.parseDouble(p);
      q2 = Double.parseDouble(q);
    } catch (NumberFormatException e) {
      return "Both q and p should be numbers.";
    }
    return BigDecimal.valueOf(q2).add(BigDecimal.valueOf(p2)).toString();
  }
}
