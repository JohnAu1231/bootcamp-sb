package com.bootcamp.demo_restful.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import com.bootcamp.demo_restful.model.dto.User.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


// JPA will generate the DDL (Create Tale) by the defintion in Entity Classes

@Entity
@Getter
@Setter
@Table(name = "Users")
public class UserEntity implements Serializable {

  @Id // Table Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
  // @Column(name ="user_id")
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

   @OneToMany(mappedBy = "user", //
      cascade = CascadeType.ALL)
  private List<PostEntity> posts = new ArrayList<>();

    // Cascade:
  // PERSIST: When the parent entity is persisted (saved), the child entities
  // will also be persisted.
  // MERGE: When the parent entity is merged (updated), the child entities will
  // also be merged.
  // REMOVE: When the parent entity is removed (deleted), the child entities
  // will also be removed.
  // REFRESH: When the parent entity is refreshed, the child entities will also
  // be refreshed.
  // DETACH: When the parent entity is detached, the child entities will also be
  // detached.
}
