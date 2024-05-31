package com.bootcamp.demo_dto_sb.exceptions;

import com.bootcamp.demo_dto_sb.infra.BusinessRuntimeException;
import com.bootcamp.demo_dto_sb.infra.SysCode;

public class ListAddException extends BusinessRuntimeException{
  
  public ListAddException() {
    super(SysCode.LIST_ADD_FAIL);
  }
}
