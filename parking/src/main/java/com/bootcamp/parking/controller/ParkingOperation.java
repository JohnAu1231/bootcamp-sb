package com.bootcamp.parking.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.parking.model.Park;

public interface ParkingOperation {
  
  @GetMapping(value = "/availablepark/carpark")
  @ResponseStatus(value = HttpStatus.OK)
  List<Park> getParks();
}
