package com.leetcode.algorithm.again;

import java.util.Arrays;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        Arrays.sort(array);
        return array.length == 0? 0:array[0];

    }
}