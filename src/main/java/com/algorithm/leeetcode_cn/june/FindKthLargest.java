package com.algorithm.leeetcode_cn.june;

import java.util.Arrays;

public class FindKthLargest {
    public static void main(String[] args) {

    }
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k-1];
    }
}