package com.bootcamp.demo_restful.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter

public class User {
  private int id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  @Getter
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Getter
    public static class Geo {
      @JsonProperty(value = "lat")
      private String latitude;
      @JsonProperty(value = "lng")
      private String longtitude;
    }
  }

  @Getter
  public static class Company {
    private String name;
    private String catchPhrase;
    @JsonProperty(value = "bs")
    private String business;
  }
}