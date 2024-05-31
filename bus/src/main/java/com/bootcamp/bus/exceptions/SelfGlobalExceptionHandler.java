package com.bootcamp.bus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.bus.infra.BusinessRuntimeException;
import com.bootcamp.bus.infra.ErrorResponse;
import com.bootcamp.bus.infra.GlobalExceptionHandler;

@RestControllerAdvice
public class SelfGlobalExceptionHandler extends GlobalExceptionHandler {
 // try to catch NotFoundException
  // if it is caught, call this java method, it passes the input parameter as well.
 
  // @ExceptionHandler(NotFoundException.class) // catch 
  // public ErrorResponse notFoundExceptionHandler(NotFoundException e) {
  //   return new ErrorResponse(e.getCode(), e.getMessage());
  // }

  // @ExceptionHandler(UserNotFoundException.class) // catch 
  // public ErrorResponse userNotFoundExceptionHandler(UserNotFoundException e) {
  //   return new ErrorResponse(e.getCode(), e.getMessage());
  // }

    @ExceptionHandler(BusinessRuntimeException.class) // catch 
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse businessRuntimeExceptionHandler(BusinessRuntimeException e) {
    return new ErrorResponse(e.getCode(), e.getMessage());
  }
}
