package com.practice.problems.easy;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int lowestPrice = -1;
        int maxProfit = 0;
        for(int price : prices) {
            if (lowestPrice == -1 || price < lowestPrice) {
                lowestPrice = price;
            } else {
                int sellProfile = price - lowestPrice;
                if (sellProfile > maxProfit)  maxProfit = sellProfile;
            }
        }
        return maxProfit;
    }
}
