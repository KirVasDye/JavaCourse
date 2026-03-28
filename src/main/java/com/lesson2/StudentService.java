package com.lesson2;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public List<Student> loadStudents(String path) {

        List<Student> students = new ArrayList<>();

        try {

            ObjectMapper mapper = new ObjectMapper();
            StudentsWrapper wrapper = mapper.readValue(new File(path), StudentsWrapper.class);
            students = wrapper.getStudents();

        } catch (FileNotFoundException e) {

            System.out.println(e.getMessage());
            return null;

        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }
}
