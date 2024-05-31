package com.bootcamp.exercise_calculator.exceptions;

import com.bootcamp.exercise_calculator.infra.CalculatorRuntimeException;
import com.bootcamp.exercise_calculator.infra.SysCode;

public class InvaildResponse extends CalculatorRuntimeException {

  public InvaildResponse(SysCode syscode) {
    super(syscode);
  }

}
