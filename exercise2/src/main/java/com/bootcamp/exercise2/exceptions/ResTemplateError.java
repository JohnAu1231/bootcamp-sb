package com.bootcamp.exercise2.exceptions;

import org.springframework.web.client.RestClientException;
import com.bootcamp.exercise2.infra.BusinessRuntimeException;
import com.bootcamp.exercise2.infra.SysCode;

public class ResTemplateError extends RestClientException{
  private int code;
  public ResTemplateError(SysCode sysCode) {
    super(sysCode.getDesc());
    this.code = sysCode.getCode();
  }
}
