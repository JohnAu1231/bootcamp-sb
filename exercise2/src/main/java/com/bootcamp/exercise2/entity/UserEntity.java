package com.bootcamp.exercise2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// JPA will generate the DDL (Create Tale) by the defintion in Entity Classes

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class UserEntity implements Serializable {

  @Id // Table Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
  @Column(name ="user_id")
  private Long id;
  private String name;
  @Column(name = "user_name")
  private String userName;
  private String email;
  private String phone;
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

  private String website;
  @Column(name = "company_name")
  private String companyName;
  @Column(name = "comapny_catch_phrase")
  private String companyCatchPhrase;
  @Column(name = "company_bs")
  private String companyBs;

  // user means PostEntity.class attribute
  // version wirh referenece column user_id, but without Foreign Key
  // undirectional Relation
  // @OneToMany(// mappedBy = "user", //
  //     cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  // @JoinColumn(name = "user_id")
  // private List<PostEntity> posts = new ArrayList<>();

   @OneToMany(mappedBy = "user", //java object name
      cascade = CascadeType.ALL)
      @JsonManagedReference
      @JsonIgnore
  private List<PostEntity> posts = new ArrayList<>();
}
