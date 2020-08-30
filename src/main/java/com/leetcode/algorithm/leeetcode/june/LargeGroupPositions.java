package com.leetcode.algorithm.leeetcode.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeGroupPositions {
    public List <List <Integer>> largeGroupPositions(String S) {
        if (S == null || S.length() <= 0) {
            return null;
        }

        char[] chars = S.toCharArray();

        int left = 0;
        int right = 0;
        int length = chars.length;
        List <List <Integer>> res = new ArrayList <>();
        while (left < length && right < length) {
            if (chars[left] != chars[right]) {
                if (right - left >= 3) {
                    res.add(Arrays.asList(left, right - 1));
                }
                left = right;
            }
            right++;
        }
        // break from last piece
        if (right - left >= 3) {
            res.add(Arrays.asList(left, right - 1));



        }
        return res;
    }
}