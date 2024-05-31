package com.bootcamp.sp.democalculatorsb.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sp.democalculatorsb.controller.StudentOperation;
import com.bootcamp.sp.democalculatorsb.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
public class StudentController implements StudentOperation {
  
  //add student
  @Override
  @GetMapping("/student/add")
  public List<Student> addStudent(@RequestParam String name) {
      Student.students.add(new Student(++Student.idCounter, name)); {
      return Student.students;

  }
}
  
  //get student list
  @Override
  @GetMapping("/students")
  public List<Student> geStudents() {
    return Student.students;
  }
  //remove student by name
  @Override
  @GetMapping("/student/remove")
  public List<Student> removeStudent(@RequestParam String name) {
    if (name == null)
      return null;
    List<Student> studentsToBeRemoved = new ArrayList<>();
    for (Student s:Student.students) {
      if (name.equals(s.getName()))
      studentsToBeRemoved.add(s);
    }
    return Student.students.removeAll(studentsToBeRemoved)
        ? studentsToBeRemoved
        : null;
          
    }

  //API get all student ID
  @Override
  @GetMapping("student/ids")
  public List<Integer> getAllId() {
    return Student.students.stream() //
          .map(e -> e.getStudentId()) //
          .collect(Collectors.toList());
  }

  @Override
  @GetMapping("student/ids2")
  public int[] getAllId2() {
    return Student.students.stream() //
          .mapToInt(e -> e.getStudentId()) //
          .toArray();
  }
  
  //get Student by Student name
  @Override
  @GetMapping("student/getbyname")
  public List<Student> getStudentByName(@RequestParam String name) {
    if(Student.students == null)
      return null;
    List<Student> ls = new ArrayList<>();
    for (Student s:Student.students) {
      if (name.equals(s.getName()))
          ls.add(s);
    }
    if (ls.size() == 0)
      return null;
    return ls;
  }
  
}
