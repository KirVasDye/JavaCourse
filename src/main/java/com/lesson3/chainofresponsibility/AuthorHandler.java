package com.lesson3.chainofresponsibility;

import com.lesson2.Book;

public class AuthorHandler extends BookHandler {
    private final String requiredAuthor;

    public AuthorHandler(String requiredAuthor) {
        this.requiredAuthor = requiredAuthor;
    }

    @Override
    protected boolean process(Book book) {
        return book.getAuthor().equals(requiredAuthor);
    }
}
