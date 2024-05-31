package com.bootcamp.sp.democalculatorsb.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sp.democalculatorsb.config.AppConfig;
import com.bootcamp.sp.democalculatorsb.controller.TestOperation;
import com.bootcamp.sp.democalculatorsb.model.Cat;

@Controller
@ResponseBody
public class TestController implements TestOperation {

  @Autowired(required = false)
  // (required = false) means cannot find the bean still start the server
   // Find the AppConfig object from spring context, and then interact with method
  private AppConfig appCongfig;

  @Autowired
  private AppConfig appCongifg2;

  @Autowired
  @Qualifier(value = "white")  //inject the object by bean name
  private Cat cat;

  @Override
  public Cat getWhiteCat() {
    return this.cat;
  }

  @Override
  public String testSayHello() {
    return new AppConfig().sayHello();
  }

  @Override 
  public String testSayHello2() {
    if (appCongfig == appCongifg2)
      return "YES";
    return "NO";
  }
}
