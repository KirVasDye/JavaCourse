package com.lesson3.strategy;
import com.lesson2.Student;
import com.lesson3.decorator.BookPrinter;
import com.lesson3.decorator.NumberedBookPrinter;
import com.lesson3.decorator.SimpleBookPrinter;
import com.lesson3.proxy.StudentRepository;
import com.lesson3.proxy.StudentRepositoryProxy;

import java.util.List;

public class DemoStrategy {
    public static void main(String[] args) {
        StudentRepository repo = new StudentRepositoryProxy(args[0]);

        List<Student> students = repo.getAllStudents();
        List<Student> students2 = repo.getAllStudents();

        BookPrinter printer = new SimpleBookPrinter();
        printer = new NumberedBookPrinter(printer);

        students2.stream()
                .flatMap(student -> student.getBooks().stream())
                .forEach(printer::print);
    }
}
