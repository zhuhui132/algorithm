package com.leetcode.algorithm.leeetcode.test_2018;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        merge.merge(num1, 3, num2, 3);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
//        int[] result = new int[m + n];
//        for (int i = 0; i < m; i++) {
//            result[i] = nums1[i];
//        }
//        for (int j = 0; j < n; j++) {
//            result[m + j] = nums2[j];
//        }
//        Arrays.sort(result);
//        for (int i : result) {
//            System.out.println(i);
//        }
//    }
////}