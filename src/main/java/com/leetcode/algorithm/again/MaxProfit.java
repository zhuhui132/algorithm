package com.leetcode.algorithm.again;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices.length == 0 || prices.length == 1) return 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>prices[i-1]){
                max = max+prices[i]-prices[i-1];
            }
        }
        return max;
    }
}