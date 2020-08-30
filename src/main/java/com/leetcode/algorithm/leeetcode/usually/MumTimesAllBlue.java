package com.leetcode.algorithm.leeetcode.usually;

public class MumTimesAllBlue {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3};
        MumTimesAllBlue mumTimesAllBlue = new MumTimesAllBlue();
        System.out.println(mumTimesAllBlue.numTimesAllBlue(arr));


    }

    public int numTimesAllBlue(int[] light) {
        int ans = 0;
        int curMax = 0;
        for (int i = 0; i < light.length; i++) {
            curMax = Math.max(curMax, light[i]);
            if (curMax == i + 1) {
                ans++;
            }
        }
        return ans;
    }

}