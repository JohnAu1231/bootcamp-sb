package com.bootcamp.demo_restful.infra;

import java.util.List;
import com.bootcamp.demo_restful.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiResp<T> {

  private int code;
  private String message;
  private List<T> data;

  public ApiResp(ApiRespBuilder<T> apiRespBuilder) {
    this.code = apiRespBuilder.code;
    this.message = apiRespBuilder.message;
    this.data = apiRespBuilder.data;
  }

  public static <T> ApiRespBuilder<T> builder() {
    return new ApiRespBuilder<>();
  }

  public int getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public List<T> getData() {
    return this.data;
  }

  public static class ApiRespBuilder<T> {
    private int code;
    private String message;
    private List<T> data;

    public ApiRespBuilder<T> code(int code) {
      this.code = code;
      return this;
    }

    public ApiRespBuilder<T> message(String message) {
      this.message = message;
      return this;
    }

    public ApiRespBuilder<T> data(List<T> data) {
      this.data = data;
      return this;
    }

    public ApiResp<T> build() {
      return new ApiResp<T>(this);
    }

    public ApiRespBuilder<T> ok() {
      this.code = 0;
      this.message = "Success.";
      return this;
    }

    // public ApiRespBuilder<T> badRequest() {
    // this.code = 99;
    // this.message = "Bad Request.";
    // return this;
    // }

  }

  public static void main(String[] args) {

    ApiResp<UserDTO> response = ApiResp.<UserDTO>builder() //
        .ok() //
        .data(List.of(new UserDTO())) //
        .build();
// Test RestTemplate.getForObject()
 // 1. call Web API, return JSON
 // 2. Using ObjectMapper of deserialization

 //Object -> JSON (Serialization)
 // String json = "{\"name\" : \"Vincent\"}"

    ObjectMapper mapper = new ObjectMapper();
    String jsonString = "";
    try {
      jsonString = mapper.writeValueAsString(response);
    } catch (JsonProcessingException e) {

    }
    System.out.println(jsonString);

  
  TypeReference<ApiResp<UserDTO>> reference = new TypeReference<>() {};
  try {
    ApiResp<UserDTO> response2 = mapper.readValue(jsonString, reference);
  } // {"code":0,"message":"Success.","data":[{"id":0,"name":null,"address":null,"company":null}]}
  catch (JsonProcessingException e) {
    System.out.println("error");
  }
  }
}

