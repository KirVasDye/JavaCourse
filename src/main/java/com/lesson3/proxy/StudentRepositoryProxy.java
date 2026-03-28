package com.lesson3.proxy;

import com.lesson2.Student;
import com.lesson3.strategy.StudentReader;
import com.lesson3.strategy.StudentReaderFactory;

import java.util.List;

public class StudentRepositoryProxy implements StudentRepository {

    private final String path;
    private List<Student> cache;

    public StudentRepositoryProxy(String path) {
        this.path = path;
    }

    @Override
    public List<Student> getAllStudents() {
        if (cache == null) {
            System.out.println("Loading students from file...");
            StudentReader reader = StudentReaderFactory.getReader(path);
            cache = reader.read(path);
        } else {
            System.out.println("Returning cached students");
        }
        return cache;
    }
}
