package com.bootcamp.bus.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.bus.dto.BusDTO;
import com.bootcamp.bus.model.Bus;
import jakarta.websocket.server.PathParam;

public interface BusOperation {
  
  @GetMapping(value = "bus/{stop_id}/{route}/{service_type}")
  @ResponseStatus(value = HttpStatus.OK)
  BusDTO nextBus(@PathVariable String stop_id, @PathVariable String route, @PathVariable String service_type);

  @GetMapping(value = "buses/{stop_id}/{route}/{service_type}")
  @ResponseStatus(value = HttpStatus.OK)
  List<BusDTO> nextBuses(@PathVariable String stop_id, @PathVariable String route, @PathVariable String service_type);
}
