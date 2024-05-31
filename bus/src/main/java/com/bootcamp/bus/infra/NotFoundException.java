package com.bootcamp.bus.infra;

public class NotFoundException extends BusinessException {
  
  public NotFoundException() {
    super(SysCode.NOT_FOUND);
  }

}