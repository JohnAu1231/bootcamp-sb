package com.bootcamp.exercise2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.exercise2.controller.impl.CommentController;
import com.bootcamp.exercise2.controller.impl.UserController;
import com.bootcamp.exercise2.service.CommentService;
import com.bootcamp.exercise2.service.PostService;
import com.bootcamp.exercise2.service.UserService;


@Component
public class AppRunner implements CommandLineRunner{

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private CommentService commentService;

  @Override
  public void run(String... args) {
    userService.saveUsers();;
    postService.savePosts();
    commentService.saveComments();
  }
  
}
