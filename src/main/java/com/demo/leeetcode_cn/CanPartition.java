package com.demo.leeetcode_cn;

import java.util.Arrays;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i: nums) {sum = sum+i; }

        //奇数不可分
        if (sum%2 ==1) {
            return false;
        }

        // 偶数  12467

        // 2 6
        if (nums[nums.length-1]>sum-(nums[nums.length]-1)){
            return false;
        }
        if (nums[nums.length-1]==sum-(nums[nums.length]-1)) {
            return true;
        }
        // 2 4 6
        for (int i =0;i<nums.length-1;i++){
            // 右边
            int right = nums[nums.length-1];
            if(sum-right> right){
                // 左边减 右边
                int index = (sum-right-right)/2;
                for (int j: nums) {
                    if (j == index) {
                        return true;
                    }
                }

            }else {
                return false;
            }
        }
        return false;
    }
}