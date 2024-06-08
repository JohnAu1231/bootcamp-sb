package com.bootcamp.exercise2.model.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.exercise2.entity.UserEntity;
import com.bootcamp.exercise2.model.reqDto.ExUserDTO;
import jakarta.persistence.Column;

@Component
public class UserEntityMapper {

  public UserEntity mapToUserEntity(ExUserDTO user) {
    if (user == null)
      return null;

   String addrStreet = null;
   String addrSuite = null;
   String addrCity = null;
   String addrZipcode = null;
   String addrLat = null;
   String addrLng = null;
   String companyName = null;
   String companyCatchPhrase = null;
   String companyBs = null;

    if (user.getAddress() != null) {
      addrStreet = user.getAddress().getStreet();
       addrSuite = user.getAddress().getSuite();
       addrCity = user.getAddress().getCity();
       addrZipcode = user.getAddress().getZipcode();
      if  (user.getAddress().getGeo() != null) {
        addrLat = user.getAddress().getGeo().getLatitude();
        addrLng = user.getAddress().getGeo().getLongtitude();
    }
   }

   if (user.getCompany() != null) {
    companyName = user.getCompany().getName();
    companyBs = user.getCompany().getBusiness();
    companyCatchPhrase = user.getCompany().getCatchPhrase();
   } 

    return UserEntity.builder() //
    .id(user.getId())//
    .name(user.getName()) //
    .userName(user.getUsername()) //
    .email(user.getEmail()) //
    .phone(user.getPhone()) //
    .website(user.getWebsite()) //
    .addrCity(addrCity) //
    .addrStreet(addrStreet) //
    .addrSuite(addrSuite) //
    .addrZipcode(addrZipcode) //
    .addrLat(addrLat) //
    .addrLng(addrLng) //
    .companyBs(companyBs) //
    .companyCatchPhrase(companyCatchPhrase) //
    .companyName(companyName) //
    .build();
    }
}
