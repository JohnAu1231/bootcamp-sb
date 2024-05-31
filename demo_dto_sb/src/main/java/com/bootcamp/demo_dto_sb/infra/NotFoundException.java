package com.bootcamp.demo_dto_sb.infra;

public class NotFoundException extends BusinessException {
  
  public NotFoundException() {
    super(SysCode.NOT_FOUND);
  }

}