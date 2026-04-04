package com.lesson3.chainofresponsibility;

import com.lesson2.Book;

public class YearHandler extends BookHandler {

    private final int yearThreshold;

    public YearHandler(int yearThreshold) {
        this.yearThreshold = yearThreshold;
    }

    @Override
    protected boolean process(Book book) {
        return book.getYear() > yearThreshold;
    }
}
