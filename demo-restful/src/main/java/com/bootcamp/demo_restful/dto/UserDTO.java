package com.bootcamp.demo_restful.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor

public class UserDTO {
  private int id;
  private String name;
  // private String username;
  // private String email;
  private AddressDTO address;
  // private String phone;
  // private String website;
  private CompanyDTO company;

  @AllArgsConstructor
  @Builder
  @Getter
  @ToString
  public static class AddressDTO {
    private String street;
    private String suite;
    private String city;
    // private String zipcode;
    private GeoDTO geo;

    @AllArgsConstructor
    @Builder
    @Getter
    public static class GeoDTO {

      private String latitude;

      private String longtitude;
    }
  }
  @AllArgsConstructor
  @Builder
  @Getter
  public static class CompanyDTO {
    private String name;
    // private String catchPhrase;
    @JsonProperty(value = "bs")
    private String business;
  }
}
