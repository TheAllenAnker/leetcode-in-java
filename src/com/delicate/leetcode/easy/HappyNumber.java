package com.delicate.leetcode.easy;

import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        HashSet<Integer> set = new HashSet<>();
        int currSum = 0;
        while (set.add(n)) {
            char[] digits = (n + "").toCharArray();
            for (char c : digits) {
                currSum += (int) Math.pow(Integer.parseInt(c + ""), 2);
            }
            if (currSum == 1) {
                return true;
            }
            n = currSum;
            currSum = 0;
        }
        return false;
    }
}
