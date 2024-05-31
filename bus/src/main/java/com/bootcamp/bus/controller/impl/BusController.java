package com.bootcamp.bus.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.bus.controller.BusOperation;
import com.bootcamp.bus.dto.BusDTO;
import com.bootcamp.bus.dto.mapper.BusMapper;
import com.bootcamp.bus.model.Bus;
import com.bootcamp.bus.service.BusService;


@RestController
public class BusController implements BusOperation {
  
  @Autowired
  private BusService busService;

  @Autowired
  private BusMapper busMapper;

  @Override
  public BusDTO nextBus(String stop_id, String route, String service_type) {
    return busMapper.mapToBusDTO(busService.getBus(stop_id, route, service_type));
  }

  @Override
  public List<BusDTO> nextBuses(String stop_id, String route, String service_type) {
    return busMapper.mapToBusDTOs(busService.getBus(stop_id, route, service_type));
  }
}
