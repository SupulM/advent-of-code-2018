package com.supulm.aoc2018.day2;

import java.util.ArrayList;
import java.util.HashMap;

public class InventoryManagement {

    public int checkSum(ArrayList<String> strings) {

        int doubles = 0;

        int triples = 0;

        for (String line : strings) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < line.length(); i++) {
                if (map.containsKey(line.charAt(i))) {
                    map.put(line.charAt(i), map.get(line.charAt(i)) + 1);
                } else {
                    map.put(line.charAt(i), 1);
                }
            }
            if (map.containsValue(2)) {
                doubles++;
            }
            if (map.containsValue(3)) {
                triples++;
            }
        }

        return doubles * triples;
    }
}
