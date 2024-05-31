package com.bootcamp.bus.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class BusDTO {
  
  String co;
  String route;
  String dest_tc;
  String dest_sc;
  String dest_en;
  String eta;
  String checkingTime;
  long secondUntilNextBus;
}
