package com.example;

import com.example.protobuf.Student;
import com.example.protobuf.Students;
import com.google.gson.Gson;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Studentprotobuf {
    public static void main(String[] args) throws IOException {

        Student student1 = Student.newBuilder().setId(1).setName("Praveen").build();
        Student student2 = Student.newBuilder().setId(2).setName("Niranjan").build();
        Student student3 = Student.newBuilder().setId(3).setName("vardhan").build();

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        Students students = Students.newBuilder().addAllStudents(studentList).build();

        Gson gson = new Gson();
        String json = gson.toJson(students);
        String filePath = "studentsprotobuf.json";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);

        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = students.toByteArray();
        System.out.println("Protobuf data length :" + bytes.length);


    }
}
