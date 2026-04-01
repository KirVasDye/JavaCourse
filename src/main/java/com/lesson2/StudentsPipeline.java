package com.lesson2;

import java.util.Comparator;
import java.util.List;

public class StudentsPipeline {

    public void performPipeline(List<Student> students) {

        students.stream()
                .peek(s -> System.out.println("Student: " + s))
                .flatMap(s -> s.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(b -> b.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        y -> System.out.println("Year: " + y),
                        () -> System.out.println("Книга отсутствует")
                );

    }

}
