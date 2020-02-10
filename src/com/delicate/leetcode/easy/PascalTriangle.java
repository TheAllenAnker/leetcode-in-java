package com.delicate.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows < 0) {
            return null;
        }
        if (numRows == 0) {
            return new ArrayList<>();
        }

        int currSize = 1;
        int num1, num2;
        int front, back;
        List<Integer> currList, preList;
        List<List<Integer>> resultList = new ArrayList<>(numRows);
        preList = new ArrayList<>(1);
        preList.add(1);
        while (currSize <= numRows) {
            front = -1;
            back = 0;
            currList = new ArrayList<>(currSize);
            for (int i = 0; i < currSize; i++) {
                num1 = front >= 0 ? preList.get(front) : 0;
                num2 = back < preList.size() ? preList.get(back) : 0;
                currList.add(num1 + num2);
                front++;
                back++;
            }
            currSize++;
            resultList.add(currList);
            preList = currList;
        }

        return resultList;
    }
}
