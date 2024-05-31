package com.bootcamp.demo_dto_sb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.bootcamp.demo_dto_sb.config.AppConfig;
import com.bootcamp.demo_dto_sb.controller.impl.StockController;
import com.bootcamp.demo_dto_sb.dto.StockDTO;
import com.bootcamp.demo_dto_sb.dto.mapper.StockMapper;
import com.bootcamp.demo_dto_sb.model.Stock;
import com.bootcamp.demo_dto_sb.service.StockService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(StockController.class)
// Create the spring context with web layer related beans only
class StockControllerTest {

  @MockBean
  private StockService stockService;

  @SpyBean
  private StockMapper stockMapper;

  @MockBean
  private AppConfig appConfig;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testGetStocks() throws Exception {
    Stock s1 = new Stock(5, "ABC", 1000);
    Stock s2 = new Stock(5, "ABC", 2000);
    Stock s3 = new Stock(10, "DEF", 20000);

    when(stockService.getAll())
        .thenReturn(new ArrayList<>(List.of(s1, s2, s3))); // when = Mockito.when


    // Simulate a client make the web request
    mockMvc.perform(MockMvcRequestBuilders.get("/stocks")) //
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].stockNo", is(5))) //
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].quantity", is(3000))) //
        .andExpect(MockMvcResultMatchers.jsonPath("$[1].stockNo", is(10))) //
        .andExpect(MockMvcResultMatchers.jsonPath("$[1].quantity", is(20000)));

    verify(stockService, times(1)).getAll();

    mockMvc.perform(MockMvcRequestBuilders.get("/stocks")) //
        .andExpect(
            MockMvcResultMatchers.jsonPath("$[*].stockNo").value(hasItem(5)))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$[*].stockNo").value(hasItem(10)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[*].quantity")
            .value(hasItem(3000)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[*].quantity")
            .value(hasItem(20000)));
  }

  @Test
  void testGetStocks2() throws Exception {
    Stock s1 = new Stock(5, "ABC", 1000);
    Stock s2 = new Stock(5, "ABC", 2000);
    Stock s3 = new Stock(10, "DEF", 20000);

    Mockito.when(stockService.getAll())
        .thenReturn(new ArrayList<>(List.of(s1, s2, s3))); // when = Mockito.when

    String json = mockMvc.perform(MockMvcRequestBuilders.get("/stocks"))
        .andReturn().getResponse().getContentAsString();

    // Deserialize JSON (No Arg Constructor)
    List<StockDTO> dtos =
        Arrays.asList(new ObjectMapper().readValue(json, StockDTO[].class));

    MatcherAssert.assertThat(dtos.stream() //
        .filter(e -> e.getStockNo() == 5) //
        .findAny() //
        .get() //
        .getQuantity(), //
        is(3000));

    MatcherAssert.assertThat(dtos.stream() //
        .filter(e -> e.getStockNo() == 10) //
        .findAny() //
        .get() //
        .getQuantity(), //
        is(20000));
    // @Test
    // void testStockService() throws Exception {
    // Stock s1 = new Stock(5, "ABC", 1000);
    // Stock s2 = new Stock(5, "ABC", 2000);
    // Stock s3 = new Stock(10, "DEF", 20000);

    // User userA = new User();
    // userA.add(new Stock(5, "AAA", 1000));
    // User userB = new User();
    // userB.add(new Stock(5, "BBB", 20000));
    // User userC = new User();
    // userC.add(new Stock(10, "CCC", 200));

    // Mockito.when(appConfig.getUsers()).thenReturn(new ArrayList<User>(List.of(userA, userB, userC)));
    // mockMvc.perform(MockMvcRequestBuilders.get("/stocks")) //
    // verify(appConfig, times(1)).getUsers();
    // }
  }
}
