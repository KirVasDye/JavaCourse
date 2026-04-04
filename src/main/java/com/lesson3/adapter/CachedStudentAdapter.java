package com.lesson3.adapter;

import com.lesson2.Student;

public class CachedStudentAdapter extends Student {
    public CachedStudentAdapter(CachedStudent student) {
        super(student.getName(), student.getBooks());
    }
}
