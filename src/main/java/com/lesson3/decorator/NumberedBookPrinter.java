package com.lesson3.decorator;

import com.lesson2.Book;

public class NumberedBookPrinter implements BookPrinter {

    private final BookPrinter wrapped;
    private int counter = 1;

    public NumberedBookPrinter(BookPrinter wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void print(Book book) {
        System.out.print(counter++ + ". ");
        wrapped.print(book);
    }
}
