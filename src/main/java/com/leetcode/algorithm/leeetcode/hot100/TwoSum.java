package com.leetcode.algorithm.leeetcode.hot100;

public class TwoSum {
    public static void main(String[] args) {
        int[] testcase =  new int[]{2,7,11,15};
        System.out.println(new TwoSum().twoSum(testcase,9 ));
    }
    int[] arrays = new int[2];
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return  arrays;
        }

        for (int i =0;i<nums.length ;i++){
            for (int j =i+1;j<nums.length;j++){
                if ((nums[i] +nums[j]) == target){
                    arrays[0] = i;
                    arrays[1] = j;
                    break;
                }
            }
        }
        return arrays;

    }
}
