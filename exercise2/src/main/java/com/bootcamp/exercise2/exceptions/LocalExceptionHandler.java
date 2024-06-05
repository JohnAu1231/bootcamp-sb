package com.bootcamp.exercise2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import com.bootcamp.exercise2.infra.ApiResp;
import com.bootcamp.exercise2.infra.ErrorCode;
import com.bootcamp.exercise2.infra.GlobalExceptionHandler;
import com.bootcamp.exercise2.infra.NotFoundException;
import com.bootcamp.exercise2.infra.SysCode;

@RestControllerAdvice
public class LocalExceptionHandler extends GlobalExceptionHandler {
  
     @ExceptionHandler(InvalidInputException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> invalidInputExceptionHandler(InvalidInputException e) {
    return ApiResp.<Void>builder() //
                  .error(SysCode.INVALID_INPUT) //
                  .build();
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> notFoundExceptionHandler(NotFoundException e) {
    return ApiResp.<Void>builder() //
                  .error(SysCode.USER_ID_NOT_FOUND) //
                  .build();
  }
  

  // @ExceptionHandler(ResTemplateError.class)
  // @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  // public ApiResp<Void> restTemplateErrorHandler(ResTemplateError e) {
  //   return ApiResp.<Void>builder() //
  //                 .error(SysCode.RESTTEMPLATE_ERROR) //
  //                 .build();
  // }

  @ExceptionHandler(RestClientException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> restTemplateErrorHandler(RestClientException e) {
    return ApiResp.<Void>builder() //
                  .error(SysCode.RESTTEMPLATE_ERROR) //
                  .build();
  }
}
