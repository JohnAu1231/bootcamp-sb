package com.bootcamp.exercise2.infra;

public class NotFoundException extends BusinessRuntimeException {
  
  public NotFoundException() {
    super(SysCode.USER_ID_NOT_FOUND);
  }

}