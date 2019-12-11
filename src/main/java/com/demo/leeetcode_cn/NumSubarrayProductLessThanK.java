package com.demo.leeetcode_cn;

import java.util.ArrayList;

/**
 * 给定一个正整数数组 nums。
 *
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int count = 0;
        for (int i = 0;i<nums.length;i++){
            count = nums[i];
            if (nums[i]< k) result++;
            for (int j = i+1;j<nums.length;j++){
                count= count *nums[j];
                if (count < k){
                    result++;
                }
                else break;
            }
        }
        return result;
    }


    // 利用除法
    //10,5,2,6


//    public int numSubarrayProductLessThanK1(int[] nums, int k) {
//        int result = 0;
//        int count = 0;
//        int sum_nums = 1
//        for (int k: nums) { sum_nums = sum_nums*k; }
//        for (int i = 0;i<nums.length;i++){
//            count = nums[i];
//            if (nums[i]< k) result++;
//            if (i==0) sum_nums =sum_nums;
//            else sum_nums = sum_nums/nums[i];
//            for (int j = nums.length-1;j<=i;j--){
//
//                while (sum_nums>= k){
//                  nums
//                   break;
//               }
//            }
//        }
//        return result;
//    }
}