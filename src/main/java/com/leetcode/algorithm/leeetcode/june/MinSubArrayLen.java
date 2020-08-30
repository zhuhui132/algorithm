package com.leetcode.algorithm.leeetcode.june;

public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int sum = 0;
        int len = 0;
        for (int j =0; j<nums.length;j++){
            sum+=nums[j];
            while(sum >= s){
                len = len ==0 ?j-i+1:Math.min(len,j-i+1 );
                sum -= nums[i++];
            }

        }
        return len;
//        int sum = 0;
//        for (int i: nums) {
//            sum = sum+i;
//        }
//        int low =0;
//        int high = nums.length-1;
//        while (low <high){
//            if (sum < s){
//                return  0;
//            }
//
//            if (nums[low]> nums[high]){
//                sum = sum-nums[low];
//                while (sum < s){
//
//                }
//            }
//        }
    }
}