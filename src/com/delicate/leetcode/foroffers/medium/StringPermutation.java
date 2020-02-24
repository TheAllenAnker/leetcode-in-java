package com.delicate.leetcode.foroffers.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringPermutation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new StringPermutation().permutation("abc")));
    }

    public String[] permutation(String s) {
        if (s == null || s.trim().length() == 0) {
            return new String[]{s};
        }

        Set<String> resultSet = new HashSet<>();
        int currIndex = 1, len = s.length();
        resultSet.add(s.charAt(0) + "");
        Set<String> tempSet;
        while (currIndex < len) {
            tempSet = new HashSet<>();
            for (String currS : resultSet) {
                char c = s.charAt(currIndex);
                String tempStr;
                for (int i = 0; i < currS.length() + 1; i++) {
                    tempStr = currS.substring(0, i) + c + currS.substring(i);
                    tempSet.add(tempStr);
                }
            }
            resultSet = tempSet;
            currIndex++;
        }
        return resultSet.toArray(new String[]{});
    }
}
