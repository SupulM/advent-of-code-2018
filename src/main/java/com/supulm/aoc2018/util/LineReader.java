package com.supulm.aoc2018.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LineReader {

    private static LineReader lineReaderInstance;

    private LineReader() {
    }

    public static LineReader getInstance() {
        if (lineReaderInstance == null) {
            lineReaderInstance = new LineReader();
        }
        return lineReaderInstance;
    }

    public <T> ArrayList<T> readLines(Class<T> clazz, String filePath) {
        final AtomicReference<ArrayList<T>> list = new AtomicReference<>(new ArrayList<>());

        Supplier<Stream<String>> supplier = returnStream(filePath);
        Stream<String> stream = supplier.get();

        stream.forEach(line -> {
            if (clazz.equals(String.class)) {
                list.get().add(clazz.cast(line));
            } else if (clazz.equals(Double.class)) {
                list.get().add(clazz.cast(Double.parseDouble(line)));
            }
        });

        return list.get();
    }

    private Supplier<Stream<String>> returnStream(String filePath) {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            return () -> stream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
