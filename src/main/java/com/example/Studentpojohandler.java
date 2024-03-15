package com.example;

import com.example.GrpcSpringboot.model.Student;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Studentpojohandler {
    public static void main(String[] args)  {


        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1, "sridhar");
        Student student2 = new Student(2, "vinayvarma");
        Student student3 = new Student(3, "laya");

        students.add(student1);
        students.add(student2);
        students.add(student3);

        Gson gson = new Gson();
        String json = gson.toJson(students);

        String filePath = "students.json";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);

        } catch (IOException e) {
            e.printStackTrace();
        }


        byte[] jsonBytes = json.getBytes(StandardCharsets.UTF_8);
        System.out.println("Pojo JSONbytes length-" + jsonBytes.length);


    }
}
