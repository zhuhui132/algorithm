package com.company.dem.array;

/**
 * Demo TwoSum
 *
 * @author zhuhui
 * @date 2019/1/25
 */
public class TwoSum {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                   a =  new int[]{i, j};
                }
            }
        }
        return a;
    }
}
