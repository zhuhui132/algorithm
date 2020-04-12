package com.algorithm.leeetcode_cn;

import java.util.Arrays;

public class GenerateTheString {
    public String generateTheString(int n) {
        //奇数 = 奇数
        //偶数 = 奇数+偶数
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');
        if (n % 2 == 1) return new String(arr);

        arr[0] = 'b';
        return new String(arr);
    }
}