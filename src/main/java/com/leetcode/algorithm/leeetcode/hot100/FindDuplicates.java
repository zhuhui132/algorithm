package com.leetcode.algorithm.leeetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] arrays = new  int[]{4,3,2,2,7,8,2,3,1};
        System.out.println(new FindDuplicates().findDuplicates(arrays));
    }

        public List <Integer> findDuplicates ( int[] nums){
            Arrays.sort(nums);
            List <Integer> list = new ArrayList <>();
            //
            if (nums.length == 0) {
                return list;
            }
            int count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if ((nums[i] == nums[i + 1])) {

                    list.add(nums[i]);
                    i++;
                }
            }
            return list;
        }

}