package com.bootcamp.bus.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Bus {

  String type;
  String version;
  String generated_timestamp;
  List<Data> data;

  @Getter
  public static class Data {
    String co;
    String route;
    String dir;
    String service_type;
    String seq;
    String dest_tc;
    String dest_sc;
    String dest_en;
    String eta_seq;
    String eta;
    String rmk_tc;
    String rmk_sc;
    String rmk_en;
    String data_timestamp;



  }
}
