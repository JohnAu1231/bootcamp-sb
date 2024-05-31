package com.bootcamp.bus.infra;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Scheme {
  
  HTTPS("https"), //
  HTTP("http"), //
  ;

  private String value;

 public String lowercase() {
  return this.value.toLowerCase();
 }
}
