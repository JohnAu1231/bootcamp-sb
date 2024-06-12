package com.bootcamp.exercise2.exceptions;

import lombok.Getter;

@Getter
public enum LocalSysCode {
  USER_ID_NOT_FOUND(1, "User ID not found."), //
  INVALID_INPUT(2, "Invalid Input"), //
  RESTTEMPLATE_ERROR(3, "RestTemplate Error - JsonPlaceHolder"), //
  NO_SUCH_ELEMENT(4, "No Value Present"), //

  ;

  private int code;
  private String desc;

  private LocalSysCode(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
