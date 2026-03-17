package com.lesson2;
import java.util.List;

public class Student {
    private String name;
    private List<Book> books;
    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }
    public Student() {}
    public List<Book> getBooks() {
        return books;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    @Override
    public String toString() {
        return String.format(
                "Student{name='%s', books=%s}",
                name, books
        );
    }
}