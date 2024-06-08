package com.bootcamp.demo_restful.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo_restful.dto.reqDto.UserReqDTO;
import com.bootcamp.demo_restful.entity.UserEntity;
import com.bootcamp.demo_restful.infra.NotFoundException;
import com.bootcamp.demo_restful.infra.Scheme;
import com.bootcamp.demo_restful.model.dto.User;
import com.bootcamp.demo_restful.repository.UserRespository;
import com.bootcamp.demo_restful.service.UserService;

@Service
public class UserServiceImpl implements UserService{
  
  //During the server start, bean creation process will consider @Value.
  // Read the yml and inject value into the bean attribute
  @Value(value = "${api.json-place-holder.domain}")
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.users}")
  private String usersEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private List<User> userList;

  //Spring will generate the class to implement the interface(UserRespository)
  // put it into responsitory
  @Autowired
  private UserRespository userRespository;

  @Override
  public List<User> getUsers() {
    // RestTemplate
    String url = UriComponentsBuilder.newInstance() //
                  .scheme(Scheme.HTTPS.lowercase()) // https or http
                  .host(this.domain) //
                  .path(this.usersEndpoint) //
                  .toUriString();

    User[] users = restTemplate.getForObject(url, User[].class);
    // new RestTemplate().getForObject
    // 1. call API, and get json result
    // 2. Convert json result to java object(User[].class)
    return Arrays.asList(users);

  }

  @Override
  public UserEntity getUserById(Long id) {
    Optional<UserEntity> userEntity = userRespository.findById(id);
    if (userEntity.isPresent()) 
      return userEntity.get();
    throw new NotFoundException();
  }

  @Override
  public UserEntity getUserByPhone(String phone) {
    Optional<UserEntity> userEntity = Optional.of(userRespository.findByPhone(phone));
    if (userEntity.isPresent())
      return userEntity.get();
    throw new NotFoundException();
  }

  @Override
  public List<UserEntity>  getUserByName(String name) {
    Optional<List<UserEntity>> userEntities = Optional.of(userRespository.findByName(name));
    if (userEntities.isPresent())
      return userEntities.get();
    throw new NotFoundException();
  }

  @Override
  public List<UserEntity> getUserNameOrderById(String name) {
    Optional<List<UserEntity>> userEntities = Optional.of(userRespository.findByNameOrderByIDDesc(name));
    if (userEntities.isPresent()) 
      return userEntities.get();
    throw new NotFoundException();
  }

  @Override
  public List<UserEntity> getUserbyAddLatGreaterThan(Double latitude) {
    Optional<List<UserEntity>> userEntities = userRespository.findByAddrLatGreaterThan(latitude);
    if (userEntities.isPresent())
      return userEntities.get();
    throw new NotFoundException();
  }

  // @Override
  // public User save(User user) {
  //   boolean duplicate = userList.stream() //
  //           .anyMatch(e -> e.getId() == user.getId()); //
  //   if (!duplicate) {
  //     userList.add(user);
  //     return user;
  //   }
  //   throw new RuntimeException();
   
  // }

  @Override 
  public UserEntity save(UserEntity user) {
    return userRespository.save(user);
  }

  @Override
  public UserEntity deleteById(Long id) { // id not exists?
    Optional<UserEntity> userEntity = userRespository.findById(id);
    if (userEntity.isPresent()) {
      userRespository.deleteById(id);
      return userEntity.get();
    }
    throw new NotFoundException();
  }

  @Override
    public UserEntity updateUser(Long id, UserEntity user) {

      Optional<UserEntity> userEntity = userRespository.findById(id);
    if (userEntity.isPresent()) {
        userRespository.save(user);
      return user;
    }
    throw new NotFoundException();
  }

  @Override
  public UserEntity updateEmailById(Long id, UserReqDTO userReqDTO) {
    Optional<UserEntity> userEntity = userRespository.findById(id);
    if (userEntity.isPresent()) {
      UserEntity entity = userEntity.get();
      entity.setEmail(userReqDTO.getEmail());
      userRespository.save(entity); 
      return entity;
    }
    throw new NotFoundException();
  }

  @Override
 public Integer updateUserEmail(Long id, String email) {
  return userRespository.updateUserEmail(id, email);
  }


  
}
