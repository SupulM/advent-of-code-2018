package com.supulm.aoc2018.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class InventoryManagement {

    public int checkSum(ArrayList<String> strings) {

        int doubles = 0, triples = 0;

        for (String line : strings) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < line.length(); i++) {
                if (map.containsKey(line.charAt(i))) {
                    map.put(line.charAt(i), map.get(line.charAt(i)) + 1);
                } else {
                    map.put(line.charAt(i), 1);
                }
            }
            if (map.containsValue(2)) doubles++;
            if (map.containsValue(3)) triples++;
        }

        return doubles * triples;
    }

    public String getBoxesDifferFromOneLetter(ArrayList<String> boxesList) {

        ArrayList<Integer> indexes = new ArrayList<>();
        int lineLength = boxesList.get(0).length();

        for (int i = 0; i < boxesList.size(); i++) {
            for (int j = 0; j < boxesList.size(); j++) {
                int differentLetterCount = 0;
                if (i != j) {
                    for (int k = 0; k < lineLength; k++) {
                        if (boxesList.get(i).charAt(k) != boxesList.get(j).charAt(k)) {
                            differentLetterCount++;
                        }
                    }
                    if (differentLetterCount == 1) {
                        indexes.addAll(Arrays.asList(i, j));
                        return getCommonLetters(boxesList.get(i), boxesList.get(j));
                    }
                }
            }
        }

        return "";
    }

    public String getCommonLetters(String boxOne, String boxTwo) {
        String commonString = "";
        for (int i = 0; i < boxOne.length(); i++)
            if (boxOne.charAt(i) == boxTwo.charAt(i)) {
                commonString += boxOne.charAt(i);
            }

        return commonString;
    }
}
