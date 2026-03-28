package com.lesson3.decorator;

import com.lesson2.Book;

public class SimpleBookPrinter implements BookPrinter {
    @Override
    public void print(Book book) {
        System.out.println(book);
    }
}
