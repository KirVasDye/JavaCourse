package com.lesson3.chainofresponsibility;

import com.lesson2.Book;

public class PagesHandler extends BookHandler {

    private final int pagesThreshold;

    public PagesHandler(int pagesThreshold) {
        this.pagesThreshold = pagesThreshold;
    }

    @Override
    protected boolean process(Book book) {
        return book.getPages() > pagesThreshold;
    }
}
