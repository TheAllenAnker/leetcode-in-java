package com.delicate.leetcode.foroffers.bytedance;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit += (prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0);
        }
        return maxProfit;
    }
}
