package com.bootcamp.demo_restful.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo_restful.entity.UserEntity;

@Repository //bean
// Hibernate 
// Generatethe class implementing this JPA interface
public interface UserRespository extends JpaRepository<UserEntity, Long>{
  
  // select * from users where phone = ?
  UserEntity findByPhone(String phone);

  //select * from users where addrLat = ? and addrLng = ?
  UserEntity findByAddrLatAndAddrLng(String addrLat, String addrLng);




  UserEntity findByAddrCityAndWebsiteAndCompanyBs(String addrCity, String website, String compnayBs);

  List<UserEntity> findByName(String name);

  List<UserEntity> findByNameOrderByIdDesc(String name);


  //Can JPA Method Naming Convention support the following SQL syntax?
  // order by?

  //like '%Lau%'

  // select specific fields?

  // group by? having?

  // max, min, sum ,avg?
}
