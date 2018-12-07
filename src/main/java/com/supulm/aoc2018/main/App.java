package com.supulm.aoc2018.main;

import com.supulm.aoc2018.util.ResourceUtils;
import com.supulm.aoc2018.util.LineReader;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        // Day 1 Part 1
        String filePath = ResourceUtils.getInstance().getFileName("day1.txt");
        ArrayList<Double> list = LineReader.getInstance().readLines(Double.class, filePath);
        System.out.println(list);

    }
}

