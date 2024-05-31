package com.bootcamp.exercise_calculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.exercise_calculator.infra.CalculatorRuntimeException;
import com.bootcamp.exercise_calculator.infra.ErrorResponse;
import com.bootcamp.exercise_calculator.infra.GlobalExceptionHandler;
import com.bootcamp.exercise_calculator.infra.SysCode;


@RestControllerAdvice
public class SelfGlobalExceptionHandler extends GlobalExceptionHandler {
  


  @ExceptionHandler(ArithmeticException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse calculatorRuntimeExceptionHandler(ArithmeticException e) {
    return new ErrorResponse(SysCode.INVAILD_Y.getCode(), SysCode.INVAILD_Y.getDesc());
  }

  @ExceptionHandler(NumberFormatException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse calculatorRuntimeExceptionHandler(NumberFormatException e) {
    return new ErrorResponse(SysCode.INVAILD_XY.getCode(), SysCode.INVAILD_XY.getDesc());
  }

  @ExceptionHandler(CalculatorRuntimeException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse calculatorRuntimeExceptionHandler(CalculatorRuntimeException e) {
    return new ErrorResponse(e.getCode(), e.getMessage());
  }

}
