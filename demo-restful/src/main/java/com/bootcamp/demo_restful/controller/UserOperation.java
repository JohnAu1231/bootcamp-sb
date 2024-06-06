package com.bootcamp.demo_restful.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.demo_restful.dto.reqDto.UserReqDTO;
import com.bootcamp.demo_restful.dto.resoDto.UserDTO;
import com.bootcamp.demo_restful.entity.UserEntity;
import com.bootcamp.demo_restful.infra.ApiResp;
import com.bootcamp.demo_restful.model.dto.User;

public interface UserOperation {

  @GetMapping(value = "/jsonplaceholder/users")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResp<UserDTO> getUsers();

  // @PostMapping(value = "/users")
  // @ResponseStatus(value = HttpStatus.OK)
  // User saveUser(@RequestBody User user);

  @GetMapping(value = "/user")
  ApiResp<UserEntity> getUserById(@RequestParam Long id);


  @GetMapping(value = "/getbyname")
  ApiResp<UserEntity> getUserByName(@RequestParam String name);

  @GetMapping(value = "/user/getbyname")
  ApiResp<UserEntity> getUserByNameOrderById(@RequestParam String name);

  @PostMapping(value = "/user")
  ApiResp<UserEntity> saveUser(@RequestBody UserEntity user);

  @DeleteMapping(value = "/user")
  ApiResp<UserEntity> deleteUser(@RequestParam Long id);

  @PutMapping(value = "/user") // Similar to SQL "update users where id = ?"
  ApiResp<UserEntity> updateUser(@RequestParam Long id,
      @RequestBody UserEntity user);

  @PatchMapping(value = "/user/email")
  ApiResp<UserEntity> updateUserEmailById(@RequestParam Long id,
      @RequestBody UserReqDTO userReqDTO);


  @GetMapping(value = "/user/addr/lat/greater")
  List<UserEntity> getUserbyAddLatGreaterThan(@RequestParam Double latitude);

  @PatchMapping(value = "/user/email/{email}/{id}")
  Integer updateUserEmail(@PathVariable Long id, @PathVariable String email);
}
