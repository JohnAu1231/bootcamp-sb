package com.bootcamp.exercise2;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MultiValueMap;
import com.bootcamp.exercise2.Controller.impl.UserController;
import com.bootcamp.exercise2.config.AppConfig;
import com.bootcamp.exercise2.model.mapper.UserMapper;
import com.bootcamp.exercise2.model.reqDto.ExCommentDTO;
import com.bootcamp.exercise2.model.reqDto.ExPostDTO;
import com.bootcamp.exercise2.model.reqDto.ExUserDTO;
import com.bootcamp.exercise2.model.respDto.UserDTO;
import com.bootcamp.exercise2.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebMvcTest(UserController.class)
class UserControllerTest {

    @MockBean
    private UserService userService;

    @SpyBean
    private UserMapper userMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetUsers() throws Exception {
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

        mockMvc.perform(MockMvcRequestBuilders.get("/users")) //
                .andExpect(MockMvcResultMatchers.status().isOk())//
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.length()").value(2))//
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))//
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))//
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].email")
                        .value("123@gmail.com"))//
        ;
        verify(userService, times(1)).getUsers();

    }

}
