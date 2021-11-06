package com.practice.problems.hard;

// 123. 买卖股票的最佳时机 III
public class BestTimeToBuyAndSellStockIii {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            System.out.println("buy1 " + buy1);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            System.out.println("sell1 " + sell1);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            System.out.println("buy2 " + buy2);
            sell2 = Math.max(sell2, buy2 + prices[i]);
            System.out.println("sell2 " + sell2);
        }
        return sell2;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIii i = new BestTimeToBuyAndSellStockIii();
        int[] prices = new int[]{ 3,3,5,0,0,3,1,4 };
        int maxProfit = i.maxProfit(prices);
    }
}
