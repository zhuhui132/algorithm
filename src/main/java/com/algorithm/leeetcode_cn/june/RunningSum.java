package com.algorithm.leeetcode_cn.june;

public class RunningSum {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int sum = 0;
        for (int i = 0 ;i < nums.length ;i++){
            sum = sum +nums[i];
            res[i] = nums[i];
        }
        return res;

    }
}

