package com.algorithm.leeetcode_cn.june;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SortByBits {
    public static void main(String[] args) {
        SortByBits sortByBits = new SortByBits();
        sortByBits.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});


    }

    public int[] sortByBits(int[] arr) {
        Integer[] tmp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
            tmp[i] = new Integer(arr[i]);
        //重写排序
        Arrays.sort(tmp, new Comparator <Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                int c1 = Integer.bitCount(o1);
                int c2 = Integer.bitCount(o2);
                return c1 == c2 ? o1 - o2 : c1 - c2;
            }
        });

        for (int i = 0; i < arr.length; i++)
            arr[i] = tmp[i];

        return arr;
    }
}