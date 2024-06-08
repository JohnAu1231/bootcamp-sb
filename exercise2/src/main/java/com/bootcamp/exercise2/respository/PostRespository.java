package com.bootcamp.exercise2.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.exercise2.entity.PostEntity;

@Repository
public interface PostRespository extends JpaRepository<PostEntity, Long> {
  
}
