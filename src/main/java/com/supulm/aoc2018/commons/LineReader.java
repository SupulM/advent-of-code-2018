package com.supulm.aoc2018.commons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
        ArrayList<String> stringArrayList = returnList(filePath);
        ArrayList<T> returnList = new ArrayList<>();
        for (String line : stringArrayList) {
            if (clazz.equals(String.class)) {
                returnList.add(clazz.cast(line));
            } else if (clazz.equals(Double.class)) {
                returnList.add(clazz.cast(Double.valueOf(line)));
            }
        }
        return returnList;
    }

    private ArrayList<String> returnList(String filePath) {
        ArrayList<String> strings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
