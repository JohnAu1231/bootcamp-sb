package com.bootcamp.demo_restful.infra;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

// @ContollerAdvice + @ResponseBody
public class GlobalExceptionHandler {
  
 
   @ExceptionHandler(ArithmeticException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> arithmeticExceptionExceptionHandler(ArithmeticException e) {
    return ApiResp.<Void>builder() //
                  .error(ErrorCode.AE) //
                  .build();
   
  }

  @ExceptionHandler(NumberFormatException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> numberFormatExceptionHandler(NumberFormatException e) {
    return ApiResp.<Void>builder() //
                  .error(ErrorCode.NFE) //
                  .build();
  }

   @ExceptionHandler(NullPointerException.class)
   @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> nullPointExceptionHandler(NullPointerException e) {
    return ApiResp.<Void>builder() //
                  .error(ErrorCode.NPE) //
                  .build();
  }

  @ExceptionHandler(BusinessRuntimeException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> busineesRuntimeExceptionHandler(BusinessRuntimeException e) {
    return ApiResp.<Void>builder() //
                  .code(e.getCode()) //
                  .message(e.getMessage()) //
                  .build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> unhandledException() {
    return ApiResp.<Void>builder() //
              .code(9999) //
              .message("Unhandled exception.") //
              .build();
  }

  // HttpMessageNotReadableException
 }