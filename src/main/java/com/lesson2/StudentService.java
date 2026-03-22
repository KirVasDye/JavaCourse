package com.lesson2;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public List<Student> loadStudents(String path) {

        List<Student> students = new ArrayList<>();

        try {

            JsonReader reader = Json.createReader(new FileReader(path));
            JsonObject root = reader.readObject();
            JsonArray studentsArray = root.getJsonArray("students");

            for (JsonValue studentValue : studentsArray) {

                JsonObject studentObj = studentValue.asJsonObject();
                String name = studentObj.getString("name");
                JsonArray booksArray = studentObj.getJsonArray("books");
                List<Book> books = new ArrayList<>();

                for (JsonValue bookValue : booksArray) {

                    JsonObject bookObj = bookValue.asJsonObject();
                    String title = bookObj.getString("title");
                    String author = bookObj.getString("author");
                    int pages = bookObj.getInt("pages");
                    int year = bookObj.getInt("year");
                    books.add(new Book(title, author, pages, year));

                }

                students.add(new Student(name, books));

            }

            return students;

        } catch (FileNotFoundException e){

            System.out.println(e.getMessage());
            return null;

        }
    }
}
