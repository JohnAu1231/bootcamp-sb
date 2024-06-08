package com.bootcamp.demo_restful.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.events.Comment;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "Posts")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class PostEntity implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;
  private String tittle;
  private String body;

  @ManyToOne
  @JoinColumn(name = "user_id") // DB table column name
  @JsonBackReference
  private UserEntity user; // object 


}
