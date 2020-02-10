package com.delicate.leetcode.easy;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int lowest = prices[0];
        int max = Math.max(prices[1] - prices[0], 0);
        for (int i = 1; i < prices.length; i++) {
            lowest = Math.min(lowest, prices[i]);
            max = Math.max(prices[i] - lowest, max);
        }
        return max;
    }
}
