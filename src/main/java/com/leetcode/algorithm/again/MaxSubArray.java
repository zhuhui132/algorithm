package com.leetcode.algorithm.again;

public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        maxSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});


    }
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;

        for (int i :nums){
            if (sum>0){
                sum += i;
            }
            else {
                sum = i;
            }
            ans = Math.max(ans,sum );
        }
        return ans;
    }
}