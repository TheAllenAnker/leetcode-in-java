package com.delicate.leetcode.foroffers.easy;

import java.util.Arrays;

public class NDices {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nDicesProbability(1)));
        System.out.println(Arrays.toString(nDicesProbability(2)));
    }

    public static double[] nDicesProbability(int n) {
        if (n <= 0 || n > 11) {
            throw new IllegalArgumentException();
        }

        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k < i - 1) {
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        double total = Math.pow(6, n);
        double[] result = new double[5 * n + 1];
        for (int i = 0; i < 5 * n + 1; i++) {
            result[i] = dp[n][n + i] / total;
        }
        return result;
    }
}
