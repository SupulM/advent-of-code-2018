package com.supulm.aoc2018.day3;

import com.supulm.aoc2018.commons.LineReader;
import com.supulm.aoc2018.commons.ResourceUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FabricSlicerTest {

    private FabricSlicer fabricSlicer = new FabricSlicer();
    private ArrayList<String> actualData;

    @BeforeEach
    void setUp() {
        String filePath = ResourceUtils.getInstance().getFileName("day3-luke.txt");
        this.actualData = LineReader.getInstance().readLines(String.class, filePath);
    }

    @Test
    void testLineProcessing() {
        ArrayList<String> data = new ArrayList<>(Arrays.asList("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2"));
        assertEquals(4, fabricSlicer.processAndGetArea(data));
    }

    @Test
    void testMultipleClaimedAreaWithActualData() {
        assertEquals(124850, fabricSlicer.processAndGetArea(this.actualData));
    }
}