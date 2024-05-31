package com.bootcamp.bus.dto.mapper;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.bootcamp.bus.dto.BusDTO;
import com.bootcamp.bus.model.Bus;
import com.bootcamp.bus.model.Bus.Data;

@Component
public class BusMapper {

  public BusDTO mapToBusDTO(Bus bus) {
    String eta = bus.getData().get(0).getEta();
    String now = bus.getData().get(0).getData_timestamp();
    LocalDateTime next = LocalDateTime.parse(eta.substring(0, 19));
    LocalDateTime nowTime = LocalDateTime.parse(now.substring(0, 19));
    long duration = Duration.between(nowTime, next).toSeconds();
    return BusDTO.builder() //
        .co(bus.getData().get(0).getCo()) //
        .route(bus.getData().get(0).getRoute()) //
        .dest_tc(bus.getData().get(0).getDest_tc()) //
        .dest_sc(bus.getData().get(0).getDest_sc()) //
        .dest_en(bus.getData().get(0).getDest_en()) //
        .eta(bus.getData().get(0).getEta()) //
        .checkingTime(bus.getData().get(0).getData_timestamp()) //
        .secondUntilNextBus(duration) //
        .build();
  }

  public List<BusDTO> mapToBusDTOs(Bus bus) {

    return bus.getData().stream() //
        .map(e -> {
          String eta = e.getEta();
          String now = e.getData_timestamp();
          LocalDateTime next = LocalDateTime.parse(eta.substring(0, 19));
          LocalDateTime nowTime = LocalDateTime.parse(now.substring(0, 19));
          long duration = Duration.between(nowTime, next).toSeconds();
          return BusDTO.builder() //
              .co(e.getCo()) //
              .route(e.getRoute()) //
              .dest_tc(e.getDest_tc()) //
              .dest_sc(e.getDest_sc()) //
              .dest_en(e.getDest_en()) //
              .eta(e.getEta()) //
              .checkingTime(e.getData_timestamp()) //
              .secondUntilNextBus(duration) //
              .build();
        }).collect(Collectors.toList());
  }
}
