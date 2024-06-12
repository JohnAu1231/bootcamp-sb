package com.bootcamp.exercise2;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isNull;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.bootcamp.exercise2.controller.impl.CommentController;
import com.bootcamp.exercise2.entity.CommentEntity;
import com.bootcamp.exercise2.model.mapper.CommentEntityMapper;
import com.bootcamp.exercise2.model.mapper.PostEntityMapper;
import com.bootcamp.exercise2.model.mapper.UserEntityMapper;
import com.bootcamp.exercise2.model.mapper.UserMapper;
import com.bootcamp.exercise2.model.reqDto.ExCommentDTO;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.reqDto.ExUserDTO;
import com.bootcamp.exercise2.respository.CommentRespository;
import com.bootcamp.exercise2.respository.PostRespository;
import com.bootcamp.exercise2.respository.UserRespository;
import com.bootcamp.exercise2.service.CommentService;
import com.bootcamp.exercise2.service.PostService;
import com.bootcamp.exercise2.service.UserService;

@WebMvcTest(CommentController.class)
public class CommentControllerTest {

        @MockBean
        private UserService userService;

        @MockBean
        private PostService postService;

        @MockBean
        private CommentService commentService;

        @SpyBean
        private UserMapper userMapper;

        @SpyBean
        private UserEntityMapper userEntityMapper;

        @SpyBean
        private CommentEntityMapper commentEntityMapper;

        @SpyBean
        private PostEntityMapper postEntityMapper;

        @MockBean
        private CommentRespository commentRespository;

        @MockBean
        private UserRespository userRespository;

        @MockBean
        private PostRespository postRespository;

        @Autowired
        private MockMvc mockMvc;

        @Test
        void testGetCommentById() throws Exception {
                // CommentEntity comment1 = CommentEntity.builder().id(2L).body("aaa").email("123@yahoo.com").name("abc").build();
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

                Mockito.when(userService.getUsers()) //
                                .thenReturn(new ArrayList<>(
                                                List.of(user1, user2)));

                mockMvc.perform(MockMvcRequestBuilders
                                .get("/commentbyapi?id=1")) //
                                .andExpect(MockMvcResultMatchers.status()
                                                .isOk()) //
                                .andExpect(MockMvcResultMatchers
                                                .jsonPath("$.id").value(1)) //
                                .andExpect(MockMvcResultMatchers
                                                .jsonPath("$.userName")
                                                .value("Cat")) //
                                .andExpect(MockMvcResultMatchers
                                                .jsonPath("$.comments[0].name")
                                                .value("a")) //
                                .andExpect(MockMvcResultMatchers
                                                .jsonPath("$.comments[0].email")
                                                .value("123@gmail.com")) //
                                .andExpect(MockMvcResultMatchers
                                                .jsonPath("$.comments[0].body")
                                                .value("hello")); //



        }
}
