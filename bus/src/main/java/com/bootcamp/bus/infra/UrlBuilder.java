package com.bootcamp.bus.infra;

import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

public class UrlBuilder {

  public static String get(Scheme scheme, String domain, String endpoint) {
    return UriComponentsBuilder.newInstance() //
        .scheme(scheme.lowercase()) //
        .host(domain) //
        .path(endpoint) //
        .toUriString();
  }

  public static String get(Scheme scheme, String domain, String endpoint,
      String... pathSegments) {
    return UriComponentsBuilder.newInstance() //
        .scheme(scheme.lowercase())//
        .host(domain) //
        .path(endpoint) //
        .pathSegment(pathSegments) //
        .toUriString();
  }

  public static String get(Scheme scheme, String domain, String endpoint,
      String queryParm, String queryValue, String... pathSegments) {
    return UriComponentsBuilder.newInstance() //
        .host(scheme.lowercase()) //
        .pathSegment(pathSegments) //
        .queryParam(queryParm, queryValue) //
        .path(endpoint) //
        .toUriString();
  }

  public static String get(Scheme scheme, String domain, String endpoint,
      MultiValueMap<String, String> params, String... pathSegments) {
    return UriComponentsBuilder.newInstance() //
        .host(scheme.lowercase()) //
        .pathSegment(pathSegments) //
        .queryParams(params) //
        .path(endpoint) //
        .toUriString();
  }
}

