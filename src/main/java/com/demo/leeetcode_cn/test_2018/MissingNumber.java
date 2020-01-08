package com.demo.leeetcode_cn.test_2018;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int result =0;
        for (int i =0;i<nums.length;i++){
            result = nums[i]^(i+1)^result;
        }
        return result;

    }
}

