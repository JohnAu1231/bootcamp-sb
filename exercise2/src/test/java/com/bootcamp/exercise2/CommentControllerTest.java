package com.bootcamp.exercise2;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.bootcamp.exercise2.Controller.impl.CommentController;
import com.bootcamp.exercise2.model.mapper.UserMapper;
import com.bootcamp.exercise2.model.reqDto.ExCommentDTO;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.reqDto.ExUserDTO;
import com.bootcamp.exercise2.service.UserService;

@WebMvcTest(CommentController.class)
public class CommonControllerTest {
  
  @MockBean
  private UserService userService;

  @SpyBean
  private UserMapper userMapper;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testGetCommentById() throws Exception {
        ExCommentDTO comment1 =
                new ExCommentDTO(1, 1, "a", "123@gmail.com", "hello");
        ExPostDTO post1 = new ExPostDTO(1, 1, "yo", "hiall");
        ExUserDTO user1 = new ExUserDTO(1, "John", "Cat", "123@gmail.com",
                new ExUserDTO.Address(), "12345678", "abc.com",
                new ExUserDTO.Company());
        ExUserDTO user2 = new ExUserDTO(2, "John", "Cat", "123@gmail.com",
                new ExUserDTO.Address(), "12345678", "abc.com",
                new ExUserDTO.Company());
        
        Mockito.when(userService.getComments()) //
                .thenReturn(new ArrayList<>(List.of(comment1)));

        Mockito.when(userService.getPosts()) //
                .thenReturn(new ArrayList<>(List.of(post1)));

        Mockito.when(userService.getUsers()) //
                .thenReturn(new ArrayList<>(List.of(user1, user2)));

        mockMvc.perform(MockMvcRequestBuilders.get("/commentbyid?id=1")) //
                .andExpect(MockMvcResultMatchers.status().isOk()) //
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                ;  


  }
}
