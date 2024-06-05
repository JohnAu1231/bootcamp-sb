package com.bootcamp.exercise2.exceptions;

import com.bootcamp.exercise2.infra.BusinessRuntimeException;
import com.bootcamp.exercise2.infra.SysCode;

public class InvalidInputException extends BusinessRuntimeException {
 public InvalidInputException(SysCode sysCode) {
  super(sysCode);
 }
  
}
