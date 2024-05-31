package com.bootcamp.sb.sbhelloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class HelloworldController {
  
  //API 接口 (Application Programming interface)
  @GetMapping(value = "/hello")  //URI  -> resource identifier
  public String hello() {
    return "hello world!";
  }

  @GetMapping(value = "/v1/hello")  //URI  -> resource identifier
  public String hello2() {
    return "hello man!";
  }

  public static void main(String[] args) {
    HelloworldController hc = new HelloworldController();
    System.out.println(hc.hello());
  }
}
