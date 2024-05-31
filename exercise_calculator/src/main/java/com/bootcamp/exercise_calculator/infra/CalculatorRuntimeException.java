package com.bootcamp.exercise_calculator.infra;

import lombok.Getter;

@Getter
public class CalculatorRuntimeException extends RuntimeException{
  
  private int code;

  public CalculatorRuntimeException(SysCode syscode) {
    super(syscode.getDesc());
    this.code = syscode.getCode();
  }
}
