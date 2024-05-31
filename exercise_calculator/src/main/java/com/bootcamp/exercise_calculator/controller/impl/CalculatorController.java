package com.bootcamp.exercise_calculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.exercise_calculator.controller.CalculatorOperation;
import com.bootcamp.exercise_calculator.dto.CalculatorDTO;
import com.bootcamp.exercise_calculator.dto.mapper.CalculatorMapper;
import com.bootcamp.exercise_calculator.model.Calculator;
import com.bootcamp.exercise_calculator.service.CalculatorService;


@RestController
public class CalculatorController implements CalculatorOperation {

  @Autowired
  private CalculatorService calculatorService;

  @Autowired
  private CalculatorMapper calculatorMapper;

  @Autowired
  private Calculator calculator;

  @Override
  public CalculatorDTO get(String x, String y, String operation) {
    calculator.setX(x);
    calculator.setY(y);
    calculator.setOpertaion(operation);
    double result = Double.parseDouble(calculatorService.get(x,y,operation));
    return calculatorMapper.mapToCalculatorDTO(calculator, result);
  }

  @Override
  public CalculatorDTO get2(String x, String y, String operation) {
    calculator.setX(x);
    calculator.setY(y);
    calculator.setOpertaion(operation);
    double result = Double.parseDouble(calculatorService.get(x,y,operation));
    return calculatorMapper.mapToCalculatorDTO(calculator, result);
  }

  @Override
  public String cal(Calculator calculator) {
    return calculatorService.get(calculator.getX(), calculator.getY(), calculator.getOpertaion());
  }

 
}
