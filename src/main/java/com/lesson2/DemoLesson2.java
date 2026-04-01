package com.lesson2;

import java.util.List;


public class DemoLesson2 {

    public static void main(String[] args) {

        StudentService service = new StudentService();

        StudentsPipeline pipeline = new StudentsPipeline();

        List<Student> students = service.loadStudents(args[0]);

        pipeline.performPipeline(students);

    }

}
