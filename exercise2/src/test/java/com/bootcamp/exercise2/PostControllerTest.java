package com.bootcamp.exercise2;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.bootcamp.exercise2.controller.impl.PostController;
import com.bootcamp.exercise2.entity.CommentEntity;
import com.bootcamp.exercise2.entity.PostEntity;
import com.bootcamp.exercise2.entity.UserEntity;
import com.bootcamp.exercise2.model.mapper.CommentEntityMapper;
import com.bootcamp.exercise2.model.mapper.PostEntityMapper;
import com.bootcamp.exercise2.model.mapper.UserMapper;
import com.bootcamp.exercise2.model.reqDto.ExCommentDTO;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.reqDto.ExUserDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO.PostDTO.CommentDTO;
import com.bootcamp.exercise2.respository.CommentRespository;
import com.bootcamp.exercise2.respository.PostRespository;
import com.bootcamp.exercise2.respository.UserRespository;
import com.bootcamp.exercise2.service.CommentService;
import com.bootcamp.exercise2.service.PostService;
import com.bootcamp.exercise2.service.UserService;

@WebMvcTest(PostController.class)
public class PostControllerTest {
  
  @MockBean
  private UserService userService;

  @MockBean 
  private PostService postService;

  @MockBean
  private CommentService commentService;

  @SpyBean
  private UserMapper userMapper;

  @SpyBean
  private PostEntityMapper postEntityMapper;

  @SpyBean 
  private CommentEntityMapper commentEntityMapper;

  @MockBean
  private UserRespository userRespository;

  @MockBean
  private PostRespository postRespository;

  @MockBean
  private CommentRespository commentRespository;

  @Autowired
  private MockMvc mockMvc;

  @BeforeAll
  static void init() {
  }

  @Test
  void testGetPosts() throws Exception{
    ExCommentDTO comment1 = new ExCommentDTO(1L, 1L, "a",
    "123@gmail.com", "hello");
ExPostDTO post1 = new ExPostDTO(1L, 1L, "yo", "hiall");
ExUserDTO user1 = new ExUserDTO(1L, "John", "Cat",
    "123@gmail.com", new ExUserDTO.Address(),
    "12345678", "abc.com", new ExUserDTO.Company());
ExUserDTO user2 = new ExUserDTO(2L, "John", "Cat",
    "123@gmail.com", new ExUserDTO.Address(),
    "12345678", "abc.com", new ExUserDTO.Company());
    Mockito.when(commentService.getComments()) //
    .thenReturn(new ArrayList<>(List.of(comment1)));
    Mockito.when(postService.getPosts()) //
    .thenReturn(new ArrayList<>(List.of(post1)));  
  }

  @Test
  void testGetPostsFromDB() throws Exception{
    UserEntity ue1 = new UserEntity(1L, 
    "name", "userName","email", 
    "phone", "street", "suite", "city", "zipcode", "lat", "lng", "website", "company", "catch", "bs", null);
    CommentEntity ce1 = new CommentEntity(1L, "name", 
    "body", "email", null);
    CommentDTO cdto1 = new CommentDTO(1L, "name", "email", "body");
    PostEntity pe1 = new PostEntity(1L, "title", "body", ue1, new ArrayList<>(List.of(ce1)));
    Mockito.when(postService.getPostsFromDB()) //
    .thenReturn(new ArrayList<>(List.of(pe1)));

    mockMvc.perform(MockMvcRequestBuilders.get("/posts")) //
      .andExpect(MockMvcResultMatchers.status().isOk()) //
      .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
      .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("title"))
      .andExpect(MockMvcResultMatchers.jsonPath("$[0].body").value("body"));
      // .andExpect(MockMvcResultMatchers.jsonPath("$[0].comments[0].id").value(1));
  }
}
