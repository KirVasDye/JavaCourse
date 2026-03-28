package com.lesson2;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;

public class StudentsWrapper {

    @JsonProperty("students")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "student")
    private List<Student> students;

    public StudentsWrapper() {}

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
