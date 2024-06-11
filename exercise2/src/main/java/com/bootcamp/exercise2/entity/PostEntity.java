package com.bootcamp.exercise2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class PostEntity implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name ="post_id") // JoinColumn name
  private Long id;
  // @Column(name = "user_id")
  // private Long userId;
  private String title;
  private String body;

  @ManyToOne
  @JoinColumn(name = "user_id") // DB table column name
  // @JsonBackReference
  private UserEntity user; // object , mappedBy name

  @OneToMany(mappedBy = "post", cascade = {CascadeType.ALL})
  @JsonIgnore
  @JsonManagedReference
  private List<CommentEntity> comments = new ArrayList<>();
}
