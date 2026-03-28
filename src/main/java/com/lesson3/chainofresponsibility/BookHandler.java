package com.lesson3.chainofresponsibility;

import com.lesson2.Book;

import java.util.ArrayList;
import java.util.List;

public abstract class BookHandler {

    protected BookHandler next;

    public boolean handle(Book book) {
        if (!process(book)) {
            return false;
        }
        if (next != null) {
            return next.handle(book);
        }
        return true;
    }

    protected abstract boolean process(Book book);

    public static class Builder {
        private final List<BookHandler> handlers = new ArrayList<>();

        public Builder addHandler(BookHandler handler) {
            handlers.add(handler);
            return this;
        }

        public BookHandler build() {
            if (handlers.isEmpty()) {
                throw new IllegalStateException("No handlers added");
            }

            for (int i = 0; i < handlers.size() - 1; i++) {
                handlers.get(i).next = handlers.get(i + 1);
            }

            return handlers.get(0);
        }
    }
}
