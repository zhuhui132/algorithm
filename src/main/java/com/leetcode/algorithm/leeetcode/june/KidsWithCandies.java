package com.leetcode.algorithm.leeetcode.june;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public List <Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List <Boolean> list = new ArrayList <>();

        int max = 0;
//        for (int i :candies){
//            max = Math.max(max, i+extraCandies);
//
//        }
        for (int i = 0; i < candies.length; i++) {
            candies[i] = candies[i] + extraCandies;
            max = Math.max(max, candies[i]);
        }

        for (int i : candies) {
            if (i < max) {
                list.add(false);
            } else list.add(true);
        }
        return list;
    }
}
