package com.bootcamp.exercise2.model.reqDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExUserDTO {
    private int id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Geo {
      @JsonProperty(value = "lat")
      private String latitude;
      @JsonProperty(value = "lng")
      private String longtitude;
    }
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  public static class Company {
    private String name;
    private String catchPhrase;
    @JsonProperty(value = "bs")
    private String business;
  }
}
