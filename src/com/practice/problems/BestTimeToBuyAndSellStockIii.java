package com.practice.problems;

import java.util.HashMap;
import java.util.List;

public class BestTimeToBuyAndSellStockIii {

    public int maxProfit(int[] prices) {
        var tradeMap = new HashMap<Integer, List<Integer>>();
        int startTradeIndex = 0;
        int previousPrice = prices[0];
        int previousTradeStartIndex = 0;
        for (int cursor = 1; cursor < prices.length; cursor++) {
            var currentPrice = prices[cursor];
            if (currentPrice < previousPrice) {
                // trade
                var tradeData = List.of(prices[startTradeIndex], previousPrice);
                if (tradeMap.size() < 2) {
                    tradeMap.put(startTradeIndex, tradeData);
                } else {
                    // 已经有两笔交易了
                    var lastTradeData = tradeMap.get(previousTradeStartIndex);
                    if(lastTradeData.get(0) < prices[startTradeIndex]) {
                       tradeMap.put(previousTradeStartIndex, List.of(lastTradeData.get(0), previousPrice));
                    } else if ((previousPrice - prices[startTradeIndex]) > (lastTradeData.get(1) - lastTradeData.get(0))) {
                        tradeMap.put(previousTradeStartIndex, List.of(lastTradeData.get(0), previousPrice));
                    }

                }
                previousTradeStartIndex = startTradeIndex;
                startTradeIndex = cursor;
            }
            previousPrice = currentPrice;
        }
        if (tradeMap.isEmpty()) {
            return 0;
        } else {
            return tradeMap.values().stream().mapToInt((value) -> value.get(1) - value.get(0)).sum();
        }
    }

};
