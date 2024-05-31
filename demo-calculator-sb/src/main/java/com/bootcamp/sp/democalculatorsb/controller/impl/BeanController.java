package com.bootcamp.sp.democalculatorsb.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sp.democalculatorsb.DemoCalculatorSbApplication;
import com.bootcamp.sp.democalculatorsb.controller.BeanOperation;

@Controller
@ResponseBody
public class BeanController implements BeanOperation{
  
  @Override
  public String[] getBeans() {
    return DemoCalculatorSbApplication.getContext().getBeanDefinitionNames();
  }
}
