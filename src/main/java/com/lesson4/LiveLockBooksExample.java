package com.lesson4;

import com.lesson2.Book;

import java.util.concurrent.atomic.AtomicBoolean;


public class LiveLockBooksExample {

    private static final AtomicBoolean book1Taken = new AtomicBoolean(false);
    private static final AtomicBoolean book2Taken = new AtomicBoolean(false);

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (!book1Taken.get()) {
                    book1Taken.set(true);
                    System.out.println("Thread1 взял Book1");
                    sleep(100);

                    if (book2Taken.get()) {
                        System.out.println("Thread1 уступает Book2");
                        book1Taken.set(false);
                        sleep(50);
                        continue;
                    }

                    book2Taken.set(true);
                    System.out.println("Thread1 взял Book2");
                    book1Taken.set(false);
                    book2Taken.set(false);
                    break;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                if (!book2Taken.get()) {
                    book2Taken.set(true);
                    System.out.println("Thread2 взял Book2");
                    sleep(100);

                    if (book1Taken.get()) {
                        System.out.println("Thread2 уступает Book1");
                        book2Taken.set(false);
                        sleep(50);
                        continue;
                    }

                    book1Taken.set(true);
                    System.out.println("Thread2 взял Book1");
                    book1Taken.set(false);
                    book2Taken.set(false);
                    break;
                }
            }
        });

        t1.start();
        t2.start();
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}

