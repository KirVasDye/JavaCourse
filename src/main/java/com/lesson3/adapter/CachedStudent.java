package com.lesson3.adapter;

import com.lesson2.Book;
import java.util.List;

public class CachedStudent {
    private String name;
    private int cls;
    private List<Book> books;

    public CachedStudent(String name, int cls, List<Book> books) {
        this.name = name;
        this.cls = cls;
        this.books = books;
    }

    public int getCls() {
        return cls;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
