package com.delicate.leetcode.foroffers.easy;

public class NumWays {
    public static void main(String[] args) {
        System.out.println(numWays(2));
        System.out.println(numWays(7));
    }

    public static int numWays(int n) {
        if (n < 0 || n > 100) {
            throw new IllegalArgumentException();
        }
        if (n <= 1) {
            return 1;
        }

        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];
    }
}
