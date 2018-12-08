package com.supulm.aoc2018.day1;

import com.supulm.aoc2018.commons.ResourceUtils;
import com.supulm.aoc2018.commons.LineReader;

import java.util.ArrayList;

public class ChronalCalibration {

    public double findDuplicateFrequency(ArrayList<Double> arrayList) {
        double frequency = 0.0;
        for (Double value : arrayList) {

        }
        return 0.0;
    }

    public static void main(String[] args) {
        String filePath = ResourceUtils.getInstance().getFileName("day1.txt");
        ArrayList<Double> list = LineReader.getInstance().readLines(Double.class, filePath);
        System.out.println(list);

    }

}

