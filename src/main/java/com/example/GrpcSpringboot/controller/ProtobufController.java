package com.example.GrpcSpringboot.controller;

import com.example.protobuf.Student;
import com.example.protobuf.Students;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/protobuf")
public class ProtobufController {

    @GetMapping("/students")
    public Students getStudents() {
        Student student1 = Student.newBuilder().setId(1).setName("Praveen").build();
        Student student2 = Student.newBuilder().setId(2).setName("Niranjan").build();
        Student student3 = Student.newBuilder().setId(3).setName("vardhan").build();
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        Gson gson=new Gson();
        String json = gson.toJson(studentList);

       return Students.newBuilder().addAllStudents(studentList).build();
//        return json;
    }

   }
