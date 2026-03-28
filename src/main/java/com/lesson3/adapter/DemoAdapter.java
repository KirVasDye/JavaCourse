package com.lesson3.adapter;

import com.lesson2.Book;
import com.lesson2.Student;

import java.util.List;
import java.util.stream.Collectors;

public class DemoAdapter {
    public static void main(String[] args) {

        List<CachedStudent> cachedStudents = List.of(
                new CachedStudent("Kirill", 10, List.of(
                        new Book("Java Basics", "James Gosling", 300, 2005),
                        new Book("Clean Code", "Robert Martin", 450, 2008)
                ))
        );

        List<Student> students = cachedStudents.stream()
                .map(CachedStudentAdapter::new)
                .collect(Collectors.toList());

        students.stream().forEach(System.out::println);
    }
}
