package com.lesson3.chainofresponsibility;

import com.lesson2.Student;
import com.lesson3.strategy.StudentReader;
import com.lesson3.strategy.StudentReaderFactory;

import java.util.List;

public class DemoChainOfResponsibility {
    public static void main(String[] args) {
        StudentReader reader = StudentReaderFactory.getReader(args[0]);
        List<Student> students = reader.read(args[0]);
        BookHandler handler = new BookHandler.Builder()
                .addHandler(new YearHandler(2000))
                .addHandler(new PagesHandler(300))
                .addHandler(new AuthorHandler(args[1]))
                .build();

        students.stream()
                .flatMap(s -> s.getBooks().stream())
                .filter(handler::handle)
                .forEach(System.out::println);
    }
}
