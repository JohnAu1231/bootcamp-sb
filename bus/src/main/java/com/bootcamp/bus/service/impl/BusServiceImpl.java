package com.bootcamp.bus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.bus.infra.Scheme;
import com.bootcamp.bus.infra.UrlBuilder;
import com.bootcamp.bus.model.Bus;
import com.bootcamp.bus.service.BusService;
import lombok.extern.slf4j.Slf4j;

@Service

public class BusServiceImpl implements BusService {

  @Autowired
  private RestTemplate restTemplate;

  @Value(value = "${api.bus-api-holder.domain}")
  private String domain;

  @Value(value = "${api.bus-api-holder.endpoints.bus}")
  private String busEndpoint;

  @Override
  public Bus getBus(String stop_id, String route, String service_type) {
    String[] ls = new String[] {stop_id, route, service_type};
    String url = UrlBuilder.get(Scheme.HTTPS, domain, busEndpoint, ls);
    Bus bus = restTemplate.getForObject(url, Bus.class);
    return bus;
  }
}
