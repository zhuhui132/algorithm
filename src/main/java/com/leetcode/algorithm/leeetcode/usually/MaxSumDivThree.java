package com.leetcode.algorithm.leeetcode.usually;

import java.util.Arrays;

public class MaxSumDivThree {
    public static void main(String[] args) {
        int[] ints = new int[]{3, 6, 5, 1, 8};
        System.out.println(new MaxSumDivThree().maxSumDivThree(ints));

    }


    public int maxSumDivThree(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        int tem1 = 0;
        int tem2 = 0;
        Arrays.sort(nums);
        for (int i : nums) {
            count = count + i;
        }
        if (count % 3 == 1) {
            // 3n+1  去掉 1 或者 3n+1
            for (int i : nums) {
                if (i % 3 == 1) {
                    tem1 = count - i;
                    //  System.out.println("tem1"+tem1);
                    break;
                }

            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] % 3 == 2 && nums[j] % 3 == 2) {
                        tem2 = count - nums[i] - nums[j];
                        //   System.out.println("tem2"+tem2);
                        break;
                    }
                }
                if (tem2 != 0) {
                    break;
                }
            }
        }
        //3n+2   2  3n+2   23%3 = 2   13568     5
        //3n+2   2  3n+2   23%3 = 2   11345   14%3 =2
        else if (count % 3 == 2) {
            // 2  4  7 8

            for (int i : nums) {
                if (i % 3 == 2) {
                    tem1 = count - i;
                    //   System.out.println("tem1" + tem1);
                    break;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] % 3 == 1 && nums[j] % 3 == 1) {
                        tem2 = count - nums[i] - nums[j];
                        //   System.out.println("tem2" + tem2);
                        break;
                    }
                }
                if (tem2 != 0) {
                    break;
                }
            }
        } else {
            return count;
        }
        return Math.max(tem2, tem1);

    }
}