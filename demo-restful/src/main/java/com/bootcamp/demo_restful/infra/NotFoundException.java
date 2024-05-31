package com.bootcamp.demo_restful.infra;

public class NotFoundException extends BusinessException {
  
  public NotFoundException() {
    super(SysCode.NOT_FOUND);
  }

}