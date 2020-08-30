package com.leetcode;

public class Rotate {
    public void rotate(int[] nums, int k) {
        if(k !=0){
            int temp = nums[nums.length-1];
            for (int i =nums.length;i>=0;i--){
                nums[i] = nums[i-1];
            }
            k--;
            nums[0] = temp;
        }

    }
}