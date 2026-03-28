package com.lesson3.strategy;

import com.lesson2.Student;

import java.util.List;

public interface StudentReader {
    List<Student> read(String path);
}
