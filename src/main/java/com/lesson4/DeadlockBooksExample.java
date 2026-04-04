package com.lesson4;

import com.lesson2.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeadlockBooksExample {

    private static final List<Book> books = List.of(
            new Book("Book1", "A", 100, 2001),
            new Book("Book2", "B", 200, 2002),
            new Book("Book3", "C", 300, 2003),
            new Book("Book4", "D", 400, 2004)
    );

    public static void main(String[] args) {
        List<Book> reversedBooks = new ArrayList<>(books);
        Collections.reverse(reversedBooks);

        Thread fromStart = new Thread(() -> getBooks(books, 1));
        Thread fromEnd = new Thread(() -> getBooks(reversedBooks, 2));

        fromStart.start();
        fromEnd.start();
    }

    private static void getBooks(List<Book> books, int num) {
        for (int i = 0; i < books.size() - 1; i++) {
            Book current = books.get(i);
            Book next = books.get(i + 1);

            synchronized (current) {
                System.out.println("Thread" + num + " взял " + current.getTitle());

                sleep(100);

                synchronized (next) {
                    System.out.println("Thread" + num + " взял " + next.getTitle());
                }
            }
        }
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}
