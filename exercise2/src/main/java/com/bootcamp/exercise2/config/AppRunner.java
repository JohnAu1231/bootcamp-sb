package com.bootcamp.exercise2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.exercise2.controller.impl.CommentController;
import com.bootcamp.exercise2.controller.impl.UserController;
import com.bootcamp.exercise2.service.UserService;


@Component
public class AppRunner implements CommandLineRunner{

  // @Autowired
  // private UserRespository userRespository;

  // @Autowired 
  // private PostRespository postRespository;

  // @Autowired
  // private CommentRespository commentRespository;

  @Autowired 
  private UserController userController;

  @Autowired
  private com.bootcamp.exercise2.controller.impl.PostController postController;

  @Autowired
  private CommentController commentController;

  @Autowired
  private UserService userService;

  @Override
  public void run(String... args) {
    userService.saveUsers();;
    postController.savePosts();
    commentController.saveComments();
    
   
  
  
  }
  
}
