package com.bootcamp.demo_restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo_restful.entity.PostEntity;

@Repository
public interface PostRespository extends JpaRepository<PostEntity, Long> {
  
}
