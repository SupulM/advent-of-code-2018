package com.supulm.aoc2018.day2;

import com.supulm.aoc2018.commons.LineReader;
import com.supulm.aoc2018.commons.ResourceUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagementTest {

    private InventoryManagement management = new InventoryManagement();

    private ArrayList<String> actualData = new ArrayList<>();

    @BeforeEach
    void setUp() {
        String filePath = ResourceUtils.getInstance().getFileName("day2.txt");
        this.actualData = LineReader.getInstance().readLines(String.class, filePath);
    }

    @Test
    void testCheckSum() {
        String[] data = {"abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"};
        assertEquals(12, management.checkSum(new ArrayList<>(Arrays.asList(data))));
    }

    @Test
    void testCheckSumWithActualData() {
        assertEquals(9633, management.checkSum(this.actualData));
    }
}