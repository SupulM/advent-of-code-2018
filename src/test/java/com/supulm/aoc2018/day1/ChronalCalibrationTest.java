package com.supulm.aoc2018.day1;

import com.supulm.aoc2018.commons.LineReader;
import com.supulm.aoc2018.commons.ResourceUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ChronalCalibrationTest {

    private ChronalCalibration chronalCalibration = new ChronalCalibration();

    private ArrayList<Double> doubleArrayList;


    @BeforeEach
    void setUp() {
        String filePath = ResourceUtils.getInstance().getFileName("day1.txt");
        this.doubleArrayList = LineReader.getInstance().readLines(Double.class, filePath);
    }

    @Test
    void testResultingFrequency() {
        assertEquals(-7.0, chronalCalibration.findResultingFrequency(new ArrayList<>(Arrays.asList(1.0, -6.0, 5.0, -12.0, 5.0))));
    }

    @Test
    void testFindDuplicateFrequency() {
        assertEquals(14.0, chronalCalibration.findDuplicateFrequency(new ArrayList<>(Arrays.asList(+7.0, +7.0, -2.0, -7.0, -4.0))));
    }

    @Test
    void testFindDuplicateFrequencyWithData(){
        assertEquals(709.0, chronalCalibration.findDuplicateFrequency(this.doubleArrayList));
    }

    @Test
    void TestResultingFrequencyWithData() {
        assertEquals(500.0, chronalCalibration.findResultingFrequency(this.doubleArrayList));
    }
}