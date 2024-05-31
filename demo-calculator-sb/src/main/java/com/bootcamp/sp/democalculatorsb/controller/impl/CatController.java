package com.bootcamp.sp.democalculatorsb.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sp.democalculatorsb.controller.CatOperation;
import com.bootcamp.sp.democalculatorsb.model.Cat;
import com.bootcamp.sp.democalculatorsb.model.Color;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@ResponseBody
public class CatController implements CatOperation {
  
   //Java method return Java object (Cat)
  // Spring Boot web layer (serialization - from)
  @Override
  @GetMapping(value = "/cat/test")
  public Cat test() {
      return new Cat("ABC", 13 , new ArrayList<>(List.of(Color.RED, Color.BLUE)));
  }
  
  // API return List<Cat>
  @Override
  @GetMapping(value = "/cats/test")
  public List<Cat> testCats() {
    return List.of(new Cat("A", 1, new ArrayList<>(List.of(Color.RED, Color.BLUE))), //
                  new Cat("B", 2, new ArrayList<>(List.of(Color.RED, Color.BLUE))), //
                  new Cat("C", 3, new ArrayList<>(List.of(Color.RED, Color.BLUE))));
  }

  @Override
  @GetMapping(value = "/cat/array")
  public Cat[] catArr() {
      return new Cat[] {new Cat("AA", 1, new ArrayList<>(List.of(Color.RED, Color.BLUE))), 
                        new Cat("BB", 2, new ArrayList<>(List.of(Color.RED, Color.BLUE))), 
                        new Cat("CC", 3, new ArrayList<>(List.of(Color.RED, Color.BLUE)))};
  }
  
}
