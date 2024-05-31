package com.bootcamp.demo_dto_sb;

import java.util.ArrayList;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.bootcamp.demo_dto_sb.config.AppConfig;
import com.bootcamp.demo_dto_sb.model.Stock;
import com.bootcamp.demo_dto_sb.model.User;
import com.bootcamp.demo_dto_sb.service.StockService;


@SpringBootTest // Complete Bean Env.
public class StockServiceTest {
  
  @MockBean
  private AppConfig appConfig;

  @Autowired
  private StockService stockService;

  @Test
  void testSave() {
    Stock s1 = new Stock(1, "MMM", 1111);
    Stock s2 = new Stock(2, "ABC", 2222);
    Stock s3 = new Stock(3, "DEF", 3333);

    User userA = new User();
    userA.setId(1);
    User userB = new User();
    userB.setId(2);
    List<User> users = new ArrayList<>(List.of(userA, userB));
  
    Mockito.when(appConfig.getUsers()).thenReturn(users); //when = Mockito.when
  
    stockService.save(s1, 1);

    MatcherAssert.assertThat(userA.getStocks().size(), Matchers.is(1));
    MatcherAssert.assertThat(userB.getStocks().size(), Matchers.is(0));

    stockService.save(s1, 2);
    MatcherAssert.assertThat(userA.getStocks().size(), Matchers.is(1) );
    MatcherAssert.assertThat(userB.getStocks().size(), Matchers.is(1) );

  }

}
