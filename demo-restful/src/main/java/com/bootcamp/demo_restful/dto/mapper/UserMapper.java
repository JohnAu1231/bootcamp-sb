package com.bootcamp.demo_restful.dto.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo_restful.dto.resoDto.UserDTO;
import com.bootcamp.demo_restful.model.dto.User;

@Component
public class UserMapper {
  
  public UserDTO mapToUser(User user) {
    return UserDTO.builder() //
          .name(user.getName()) //
          .id(user.getId()) //
          .address(UserDTO.AddressDTO.builder() //
                    .street(user.getAddress().getStreet()) //
                    .suite(user.getAddress().getSuite()) //
                    .city(user.getAddress().getCity()) //
                    .geo(UserDTO.AddressDTO.GeoDTO.builder() //
                                      .latitude(user.getAddress().getGeo().getLatitude())//
                                      .longtitude(user.getAddress().getGeo().getLongtitude())
                                      .build()) //
                    .build()
                    )
          .company(UserDTO.CompanyDTO.builder() //
                    .name(user.getCompany().getName()) //
                    .business(user.getCompany().getBusiness()) //
                    .build()) //
          .build();
  }
}
