package com.practice.problems.medium;

public class BestTimeToBuyAndSellStockIi {

    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        for (int index = 0; index < prices.length - 1; index ++) {
            if (prices[index] < prices[index + 1]) {
                totalProfit += prices[index + 1] - prices[index];
            }
        }
        return totalProfit;
    }
}
