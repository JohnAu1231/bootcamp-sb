package com.bootcamp.demo_dto_sb.infra;


import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.bootcamp.demo_dto_sb.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;

// @ContollerAdvice + @ResponseBody
public class GlobalExceptionHandler {
  
  @Getter
  @AllArgsConstructor
 private enum ErrorCode {
  NPE(99, "Null Pointer Exception."), //
  NFE(99, "NumberFormat Exception."), //
  AE(99, "Arithmetic Exception."),
  ;
  private int code;
  private String desc;
 }

 // Alternative
//  @ExceptionHandler(NumberFormatException.class, NullPointerException.class, ArithmeticException.class)
//  public ErrorResponse exceptionHandler(RuntimeException e) {
//   if (e instanceof NumberFormatException) {
//     return new ErrorResponse(ErrorCode.NFE.getCode(),ErrorCode.NFE.getDesc());
//   } else if (e instanceof NullPointerException) {
//     return new ErrorResponse(ErrorCode.NPE.getCode(), ErrorCode.NPE.getDesc());
//   } else if (e instanceof ArithmeticException) {
//     return new ErrorResponse(ErrorCode.AE.getCode(), ErrorCode.AE.getDesc());
//   }
//   return ErrorResponse.of(9999,"Unhandled Exception");
//  }

  @ExceptionHandler(NumberFormatException.class) // catch 
  public ErrorResponse numberNotFoundExceptionHandler(NumberFormatException e) {
    return new ErrorResponse(99, "Number Format Exception.");
  }

  //RunTImeException
  //I/O Exception

  // @ExceptionHandler(ArithmeticException.class)
  // public ErrorResponse arithmeticExceptionHandler(ArithmeticException e) {
  //   return new ErrorResponse(3, e.getMessage());
  // }

  @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
  public ErrorResponse arryaIndexOutOfBoundsExceptionHandler(ArrayIndexOutOfBoundsException e) {
    return new ErrorResponse(4, e.getMessage());
  }

  @ExceptionHandler(ClassNotFoundException.class)
  public ErrorResponse classNotFoundExceptionHandler(ClassNotFoundException e) {
    return new ErrorResponse(5, e.getMessage());
  }

  @ExceptionHandler(FileNotFoundException.class)
  public ErrorResponse fileNotFoundExceptionHandler(FileNotFoundException e) {
    return new ErrorResponse(6, e.getMessage());
  }

  @ExceptionHandler(IOException.class)
  public ErrorResponse iOExceptionHandler(IOException e) {
    return new ErrorResponse(7, e.getMessage());
  }

  // @ExceptionHandler(NullPointerException.class)
  // public ErrorResponse nullPointExceptionHandler(NullPointerException e) {
  //   return new ErrorResponse(8, e.getMessage());
  // }
  
  // @ExceptionHandler(NumberFormatException.class)
  // public ErrorResponse numberFormatExceptionHandler(NumberFormatException e) {
  //   return new ErrorResponse(9, e.getMessage());
  // }

  @ExceptionHandler(StringIndexOutOfBoundsException.class)
  public ErrorResponse stringIndexOutOfBoundsExceptionHandler(StringIndexOutOfBoundsException e) {
    return new ErrorResponse(10, e.getMessage());
  }

  @ExceptionHandler(IllegalArgumentException.class) 
  public ErrorResponse illegalArgumentExceptionHandler(IllegalArgumentException e) {
    return new ErrorResponse(11, e.getMessage());
  }

  @ExceptionHandler(IllegalStateException.class)
  public ErrorResponse illegalStateExceptionHandler(IllegalStateException e) {
    return new ErrorResponse(12, e.getMessage());
  }
  
  @ExceptionHandler(UserNotFoundException.class)
  public ErrorResponse UserNotFoundException(UserNotFoundException e) {
    return new ErrorResponse(12, e.getMessage());
  }
  
 }