package com.bootcamp.exercise_calculator.dto.mapper;

import com.bootcamp.exercise_calculator.dto.CalculatorDTO;
import com.bootcamp.exercise_calculator.model.Calculator;

public class CalculatorMapper {
  
  public CalculatorDTO mapToCalculatorDTO(Calculator calculator, double result) {
    return CalculatorDTO.builder() //
          .x(calculator.getX()) //
          .y(calculator.getY()) //
          .operation(calculator.getOpertaion()) //
          .result(String.valueOf(result)) //
          .build();
  }
}
