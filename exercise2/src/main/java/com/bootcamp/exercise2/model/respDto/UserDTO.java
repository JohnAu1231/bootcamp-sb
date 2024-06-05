package com.bootcamp.exercise2.model.respDto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserDTO {
  private int id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;
  private List<PostDTO> posts;

  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  @Getter
  public static class PostDTO {
    int id;
    String title;
    String body;
    List<CommentDTO> comments;

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class CommentDTO {
      int id;
      String name;
      String email;
      String body;
    }
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  @Getter
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class Geo {
      @JsonProperty(value = "lat")
      private String latitude;
      @JsonProperty(value = "lng")
      private String longtitude;
    }
  }
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  @Getter
  public static class Company {
    private String name;
    private String catchPhrase;
    @JsonProperty(value = "bs")
    private String business;
  }


}
