package com.company.dem.array;

import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,4};
        // 默认0
        //System.out.println(arr1[3]);
        //数组拷贝
        System.out.println(Arrays.toString(arr1));
        int dts = 6;
        int[] a = new int[arr1.length+1];
        for (int i:arr1) {
            //sou
            a[i-1] = arr1[i-1];
        }
        a[a.length-1] = dts;
        System.out.println(a.toString());

    }
}
