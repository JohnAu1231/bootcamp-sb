package com.bootcamp.demo_dto_sb.exceptions;

import com.bootcamp.demo_dto_sb.infra.BusinessRuntimeException;
import com.bootcamp.demo_dto_sb.infra.SysCode;

public class UserNotFoundException extends BusinessRuntimeException{
  
  public UserNotFoundException() {
    super(SysCode.USER_ID_NOT_FOUND);
  }

}
