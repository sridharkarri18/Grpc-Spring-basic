package com.example.GrpcSpringboot.controller;

import com.example.GrpcSpringboot.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pojo")
public class PojoController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "ganesh"));
        students.add(new Student(2, "vinayvarma"));
        students.add(new Student(3, "laya"));
        return students;
    }

    @GetMapping("/al")
    public String message(){
        return "hai";
    }
}
