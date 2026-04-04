package com.lesson3.strategy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lesson2.Student;
import com.lesson2.StudentsWrapper;

import java.io.File;
import java.util.List;

public class XmlStudentReader implements StudentReader {

    @Override
    public List<Student> read(String path) {
        try {
            XmlMapper xmlMapper = new XmlMapper();

            StudentsWrapper wrapper = xmlMapper.readValue(new File(path), StudentsWrapper.class);

            return wrapper.getStudents();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
