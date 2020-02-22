package com.delicate.leetcode.foroffers.easy;

public class LastRemaining {
    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }

    public static int lastRemaining(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return 0;
        }

        int index = 0;
        for (int i = 2; i <= n; i++) {
            index = (index + m) % i;
        }
        return index;
    }
}
