package com.bootcamp.exercise_calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Builder
public class CalculatorDTO {

  private String x;
  private String y;
  private String operation;
  private String result;
}
