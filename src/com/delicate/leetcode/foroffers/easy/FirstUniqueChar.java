package com.delicate.leetcode.foroffers.easy;

import java.util.HashMap;
import java.util.HashSet;

public class FirstUniqueChar {
    public static void main(String[] args) {
        System.out.println(firstUniqueChar(""));
        System.out.println(firstUniqueChar("abaccdeff"));
    }

    public static char firstUniqueChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }

        HashSet<Character> dataSet = new HashSet<>();
        HashMap<Character, Integer> charMap = new HashMap<>();
        int i = 0;
        for (char c : s.toCharArray()) {
            if (dataSet.contains(c)) {
                charMap.remove(c);
            } else {
                dataSet.add(c);
                charMap.put(c, i);
            }
            i++;
        }

        int minIndex = s.length();
        char result = ' ';
        for (char c : charMap.keySet()) {
            int currIndex = charMap.get(c);
            if (currIndex < minIndex) {
                result = c;
                minIndex = currIndex;
            }
        }
        return result;
    }
}
