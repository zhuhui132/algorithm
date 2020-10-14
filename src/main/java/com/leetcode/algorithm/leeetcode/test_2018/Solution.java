package com.leetcode.algorithm.leeetcode.test_2018;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] nums = new  int[]{3,1,3,4,2};
        Solution solution = new Solution();
        int result = solution.findDuplicate(nums);
        System.out.println(result);
    }
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            //System.out.println(i);
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
    }
}
