package com.bootcamp.exercise_calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.bootcamp.exercise_calculator.dto.mapper.CalculatorMapper;
import com.bootcamp.exercise_calculator.model.Calculator;
import lombok.Getter;

@Configuration
@Getter
public class AppConfig {
  
  @Bean
  CalculatorMapper beanCalMapper() {
    return new CalculatorMapper();
  }

  @Bean
  Calculator beanCal() {
    return new Calculator();
    }
  
}
