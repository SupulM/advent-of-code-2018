package com.supulm.aoc2018.day1;

import com.supulm.aoc2018.commons.ResourceUtils;
import com.supulm.aoc2018.commons.LineReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ChronalCalibration {

    // Day 1, Part 2
    public double findDuplicateFrequency(ArrayList<Double> doubleArrayList) {
        double frequency = 0.0;
        Set<Double> uniqueFrequencies = new HashSet<>();

        int i = 0;
        while (true) {
            if (!uniqueFrequencies.add(frequency)){
                return frequency;
            }
            frequency += doubleArrayList.get(i);
            i++;
            if (i >= doubleArrayList.size()){
                i = 0;
            }
        }
    }

    // Day 1, Part 1
    public double findResultingFrequency(ArrayList<Double> doubleArrayList) {
        double resultingFrequency = 0.0;
        for (double value : doubleArrayList) {
            resultingFrequency += value;
        }
        return resultingFrequency;
    }

    public static void main(String[] args) {
        String filePath = ResourceUtils.getInstance().getFileName("day1.txt");
        ArrayList<Double> list = LineReader.getInstance().readLines(Double.class, filePath);
        System.out.println(list);

    }

}

