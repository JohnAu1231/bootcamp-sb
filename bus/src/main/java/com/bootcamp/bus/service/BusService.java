package com.bootcamp.bus.service;

import com.bootcamp.bus.model.Bus;

public interface BusService {
 
  Bus getBus(String stop_id, String route, String service_type);
}
