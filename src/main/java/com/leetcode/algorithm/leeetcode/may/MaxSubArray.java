package com.leetcode.algorithm.leeetcode.may;

import java.util.HashMap;

public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        HashMap<Integer,Integer> map = new HashMap <>();
        map.put(1,2 );
        map.put(1,3 );
        System.out.println(map.get(1));
        int[] demo = maxSubArray.lost( new int[]{1,2,3,4,5,55,5,5});
//        System.out.println(maxSubArray.lost( new int[]{1,2,3,4,5,55,5,5}))    ;

        System.out.println(demo[0]+ "  "+demo[1]);

    }

    public int maxSubArray(int[] nums) {
        int min = nums[0];
        int sum = 0;
        for (int i : nums) {
            if (sum > 0) {
                sum += i;
            } else sum = i;

            min = Math.min(min, sum);
        }
        return min;
    }


    public int[] lost(int[] arr){
        HashMap<Integer,Integer> map = new HashMap <>();
        for (int i :arr){
            if (map.containsKey(i)){
                map.put(i,map.get(i)+1 );
            }
            else map.put(i,1 );
        }

        int j = map.get(arr[0]);
        int k = 0;
        for (int i =0;i< arr.length;i++){
            if (map.get(arr[i])>j){
                k =arr[i];
                j = map.get(arr[i]);
            }
        }
        return new int[]{k,j};
    }
}