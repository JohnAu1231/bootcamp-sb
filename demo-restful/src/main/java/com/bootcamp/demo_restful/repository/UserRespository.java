package com.bootcamp.demo_restful.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

  // JPQL work with Entity & JPA
  @Query(value = "SELECT e FROM UserEntity e WHERE CAST(e.addrLat AS double) > :lat")
  Optional<List<UserEntity>> findByAddrLatGreaterThan(@Param(value = "lat") Double latitude);

  // JPQL + QModifying (Update, Delete, insert)
  @Modifying
  @Query(value ="UPDATE UserEntity e SET e.email = :newEmail WHERE e.id = :userId")
  Integer updateUserEmail(@Param("userId") Long id, @Param("newEmail") String email);

  //Can JPA Method Naming Convention support the following SQL syntax?
  // order by?

  //like '%Lau%'

  // select specific fields?

  // group by? having?

  // max, min, sum ,avg?
}
