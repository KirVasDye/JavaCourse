package com.lesson3.strategy;

import java.util.Map;

public class StudentReaderFactory {
    private static final Map<String, StudentReader> readers = Map.of(
            "json", new JsonStudentReader(),
            "xml", new XmlStudentReader()
    );

    public static StudentReader getReader(String path) {
        String ext = path.substring(path.lastIndexOf('.') + 1).toLowerCase();

        StudentReader reader = readers.get(ext);

        if (reader == null) {
            throw new IllegalArgumentException("Unsupported file format: " + path);
        }

        return reader;
    }
}
