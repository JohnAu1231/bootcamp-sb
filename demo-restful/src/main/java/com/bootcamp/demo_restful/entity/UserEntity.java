package com.bootcamp.demo_restful.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import com.bootcamp.demo_restful.model.dto.User.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;


// JPA will generate the DDL (Create Tale) by the defintion in Entity Classes

@Entity
@Getter
@Table(name = "Users")
public class UserEntity {
  
  @Id // Table Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
  private Long id;
  private String name;
  @Column(name = "user_name")
  private String userName;
  // ...
  @Column(name = "addr_street")
  private String addrStreet;
  @Column(name = "addr_suite")
  private String addrSuite;
  @Column(name = "addr_city")
  private String addrCity;
  @Column(name = "addr_zipcode")
  private String addrZipcode;
  @Column(name = "addr_lat")
  private String addrLat;
  @Column(name = "addr_lng")
  private String addrLng;
  
  private String phone;
  private String website;
  @Column(name = "company_name")
  private String companyName;
  @Column(name = "comapny_catch_phrase")
  private String companyCatchPhrase;
  @Column(name = "company_bs")
  private String companyBs;

}
