package com.bootcamp.sp.democalculatorsb.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.sp.democalculatorsb.model.Student;

public interface StudentOperation {
   
    @GetMapping("/student/add")
    public List<Student> addStudent(@RequestParam String name);

    @GetMapping("/students")
    public List<Student> geStudents();

    @GetMapping("/student/remove")
    public List<Student> removeStudent(@RequestParam String name);

    @GetMapping("student/ids")
    public List<Integer> getAllId();
  
    @GetMapping("student/ids2")
    public int[] getAllId2();

    @GetMapping("student/getbyname")
    public List<Student> getStudentByName(@RequestParam String name);
}
