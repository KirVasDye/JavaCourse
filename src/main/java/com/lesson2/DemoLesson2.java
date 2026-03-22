package com.lesson2;

import java.util.List;


public class DemoLesson2 {

    public static void main(String[] args){

        System.out.println("Одним стримом:");

        StudentService service = new StudentService();

        List<Student> students = service.loadStudents(args[0]);

        StudentsPipeline.performPipeline(students);
    }

}
