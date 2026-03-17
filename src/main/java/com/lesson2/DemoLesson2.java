package com.lesson2;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class DemoLesson2 {
    public static void main2(){
        List<Student> students = new ArrayList<>();
        try {
            JsonReader reader = Json.createReader(new FileReader("A:/Projekts/untitled1/src/main/java/com/lesson2/students.json"));
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
            System.out.println("Одним стримом:");
            students.stream()
                    .peek(System.out::println) // вывести студентов
                    .flatMap(s -> s.getBooks().stream()) // получить все книги
                    .sorted(Comparator.comparingInt(Book::getPages)) // сортировка по страницам
                    .distinct() // уникальные книги
                    .filter(b -> b.getYear() > 2000) // книги после 2000 года
                    .limit(3) // ограничение
                    .map(Book::getYear) // получить годы
                    .findFirst() // short-circuit
                    .ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Книга отсутствует")
                    );
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
