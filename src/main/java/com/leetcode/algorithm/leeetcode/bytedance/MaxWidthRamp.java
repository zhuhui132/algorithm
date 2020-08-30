package com.leetcode.algorithm.leeetcode.bytedance;

import java.util.Arrays;

public class MaxWidthRamp {
    public static void main(String[] args) {
        MaxWidthRamp maxWidthRamp = new MaxWidthRamp();
        maxWidthRamp.maxWidthRamp(new int[]{3,2,1,2,1,7});
    }
    public int maxWidthRamp(int[] A) {
        // 先排序
        Arrays.sort(A);
        int move = 0;
        // 遍历数组，若当前元素小于等于它的前一个元素，则将其变为前一个数+1
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int pre = A[i];
                A[i] = A[i - 1] + 1;
                move += A[i] - pre;
            }
        }
        System.out.println(move);
        return move;
    }
}