package com.bootcamp.exercise2.respository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.exercise2.entity.CommentEntity;

@Repository
public interface CommentRespository extends JpaRepository<CommentEntity, Long>{

  List<CommentEntity> findByPostId(Long id);
  
}
