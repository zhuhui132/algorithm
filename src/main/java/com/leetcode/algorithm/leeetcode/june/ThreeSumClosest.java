package com.leetcode.algorithm.leeetcode.june;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        threeSumClosest.threeSumClosest(new int[]{-1,2,1,-4}, 1);
    }
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    // 如果已经等于target的话, 肯定是最接近的
                    return target;
                }

            }

        }

        return closestNum;
    }

//        int result = 0;
//        Arrays.sort(nums);
//        int i =0;
//        int j = nums.length-1;
//        int compare = 0;
//        while (i<j){
//            for (int k = i;k<j;k++){
//                // 总和大于 target  左移
//                if ((nums[i] + nums[j]+nums[k]) > target){
//                    j--;
//
//                }
//                else if ((nums[i] + nums[j]+nums[k]) < target){
//
//                }
//
//            }
//        }




}