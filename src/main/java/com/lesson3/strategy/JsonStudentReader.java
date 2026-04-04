package com.lesson3.strategy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson2.Student;
import com.lesson2.StudentsWrapper;

import java.io.File;
import java.util.List;

public class JsonStudentReader implements StudentReader {

    @Override
    public List<Student> read(String path) {
        try {

            ObjectMapper mapper = new ObjectMapper();

            StudentsWrapper wrapper = mapper.readValue(new File(path), StudentsWrapper.class);

            return wrapper.getStudents();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}