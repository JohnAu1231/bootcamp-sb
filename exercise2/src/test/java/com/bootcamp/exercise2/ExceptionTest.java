package com.bootcamp.exercise2;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.bootcamp.exercise2.model.mapper.UserMapper;
import com.bootcamp.exercise2.model.reqDto.ExCommentDTO;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.reqDto.ExUserDTO;
import com.bootcamp.exercise2.service.CommentService;
import com.bootcamp.exercise2.service.PostService;
import com.bootcamp.exercise2.service.UserService;

@WebMvcTest
public class ExceptionTest {
  
  @MockBean
  private UserService userService;

  @MockBean
  private PostService postService;

  @MockBean
  private CommentService commentService;

  @SpyBean
  private UserMapper userMapper;

  @MockBean
  private MockMvc mockMvc;

  public void testException() {
          ExCommentDTO comment1 =
                new ExCommentDTO(1L, 1L, "a", "123@gmail.com", "hello");
        ExPostDTO post1 = new ExPostDTO(1L, 1L, "yo", "hiall");
        ExUserDTO user1 = new ExUserDTO(1L, "John", "Cat", "123@gmail.com",
                new ExUserDTO.Address(), "12345678", "abc.com",
                new ExUserDTO.Company());
        ExUserDTO user2 = new ExUserDTO(2L, "John", "Cat", "123@gmail.com",
                new ExUserDTO.Address(), "12345678", "abc.com",
                new ExUserDTO.Company());

        Mockito.when(commentService.getComments()) //
                .thenReturn(new ArrayList<>(List.of(comment1)));

        Mockito.when(postService.getPosts()) //
                .thenReturn(new ArrayList<>(List.of(post1)));

        Mockito.when(userService.getUsers()) //
                .thenReturn(new ArrayList<>(List.of(user1, user2)));

        // mockMvc.perform(MockMvcRequestBuilders.get("/user")) //
        // .andExpect(Assertions.assertThrows(, () -> System.out.println("error")));
        // mockMvc.perform(MockMvcRequestBuilders.get("/commentbyid?id=2")) //
        // .andExpect(assertThrows(new NullPointerException(),user2))
        //         .andExpect(MockMvcResultMatchers.jsonPath("$.comments").isEmpty());

    }

}


