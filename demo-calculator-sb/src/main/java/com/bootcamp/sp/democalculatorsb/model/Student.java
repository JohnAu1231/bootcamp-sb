package com.bootcamp.sp.democalculatorsb.model;

import java.util.LinkedList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends Person{

  public final static List<Student> students = new LinkedList<>();
  public static int idCounter = 0;
  private String name;

  public Student (int studentId, String name) {
    super(studentId);
    this.name = name;
  }
}
