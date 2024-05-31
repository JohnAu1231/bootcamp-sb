package com.bootcamp.sp.democalculatorsb.controller.impl;

import java.util.Arrays;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sp.democalculatorsb.controller.DatabaseOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
public class DatabaseController implements DatabaseOperation {

  // belongs to Class
  private final static int[] arr = new int[] {10, -3, 9};
  private final static HashMap<String, Integer> map =
      new HashMap<String, Integer>();


  // Design an API, get the value from array by index
  @Override
  @GetMapping(value = "/database/value")
  public String getNumOfArr(@RequestParam String index) {
    try {
      int i = Integer.parseInt(index);
      return String.valueOf(arr[i]);

    } catch (IndexOutOfBoundsException e) {
      return "Index out of range";
    } catch (NumberFormatException e) {
      return "index should be number";
    }
  }

  // sort
  // stream
  @Override
  @GetMapping(value = "/database/sorting")
  public void sort() {
    int[] newArr = Arrays.stream(arr) //
        .boxed().sorted((i1, i2) -> i1 > i2 ? -1 : 1) //
        .mapToInt(Integer::intValue) //
        .toArray();
    for (int i = 0; i < arr.length; i++) {
      arr[i] = newArr[i];
    }
  }

  @Override
  @GetMapping(value = "/database/array")
  public String getArr() {
    String str = "";
    for (int i = 0; i < arr.length; i++) {
      if (i == arr.length - 1) {
        str = str.concat(String.valueOf(i));
        continue;
      }
      str = str.concat(String.valueOf(arr[i])).concat(",");
    }
    return str;
  }

  @Override
  @GetMapping(value = "/database/map")
  public String addMap(@RequestParam String str, @RequestParam String num) {
    try {
      int i = Integer.parseInt(num);
      map.put(str, i);
      return "add successful";
    } catch (IndexOutOfBoundsException e) {
      return "Index out of range";
    } catch (NumberFormatException e) {
      return "index should be number";
    }
  }

  @Override
  @GetMapping(value = "/database/map/value")
  public String getMap(@RequestParam String key) {
    try {
      return String.valueOf(map.get(key));

    } catch (NullPointerException e) {
      return "Map has not the key";
    }

  }
}
