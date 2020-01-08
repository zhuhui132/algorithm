package com.demo.leeetcode_cn.test_2018;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (null == nums || nums.length == 0) return -1;
        Arrays.sort(nums);
        return nums[nums.length / 2];

    }


    public int majorityElementWithMap(int[] nums) {
        if (null == nums || nums.length == 0) return -1;
        HashMap <Integer, Integer> map = new HashMap <>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count >=nums.length / 2)  {
                return i;
            }
        }
        return -1;


    }
}