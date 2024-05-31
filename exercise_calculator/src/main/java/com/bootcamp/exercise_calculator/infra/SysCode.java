package com.bootcamp.exercise_calculator.infra;

import lombok.Getter;

@Getter
public enum SysCode {
  OK(0, "success."), //
  NOT_FOUND(1, "not found."), //
  INVAILD_RESPONSE(9, "Invaild Input."), //
  INVAILD_XY(2, "Invaild Input x or y."), //
  INVAILD_OPERATION(3, "Invaild Input operation."), //
  INVAILD_Y(4, "y should not be 0.")
  ;

  private int code;
  private String desc;

  private SysCode(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}