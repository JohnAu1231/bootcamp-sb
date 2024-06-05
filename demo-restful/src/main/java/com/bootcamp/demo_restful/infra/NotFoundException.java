package com.bootcamp.demo_restful.infra;

public class NotFoundException extends BusinessRuntimeException {
  
  public NotFoundException() {
    super(SysCode.NOT_FOUND);
  }

}