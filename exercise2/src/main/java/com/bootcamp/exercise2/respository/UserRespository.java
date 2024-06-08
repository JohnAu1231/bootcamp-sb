package com.bootcamp.exercise2.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.exercise2.entity.UserEntity;
import java.util.List;


@Repository
public interface UserRespository extends JpaRepository<UserEntity, Long>{
 
}
