package com.delicate.leetcode.foroffers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindContinuousSequence {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(9)));
        System.out.println(Arrays.deepToString(findContinuousSequence(15)));
    }

    public static int[][] findContinuousSequence(int target) {
        if (target <= 0) {
            throw new IllegalArgumentException();
        }

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        int latter = 1, former = 2, sum = 3;
        while (former <= (target / 2) + 1) {
            if (sum == target) {
                for (int i = latter; i <= former; i++) {
                    currList.add(i);
                }
                resultList.add(currList);
                currList = new ArrayList<>();
                sum -= latter;
                latter++;
            } else if (sum > target) {
                sum -= latter;
                latter++;
            } else {
                former++;
                sum += former;
            }
        }

        int[][] result = new int[resultList.size()][];
        for (int i = 0; i < result.length; i++) {
            currList = resultList.get(i);
            int currSize = currList.size();
            int[] currArr = new int[currSize];
            for (int j = 0; j < currSize; j++) {
                currArr[j] = currList.get(j);
            }
            result[i] = currArr;
        }
        return result;
    }
}
