package com.algorithm.leeetcode_cn.test_2018;

import java.util.Arrays;

public class LargestSumOfAverages {


    public static void main(String[] args) {
        LargestSumOfAverages largestSumOfAverages = new LargestSumOfAverages();
        largestSumOfAverages.largestSumOfAverages(new int[]{4,1,7,5,6,2,3}, 4);
    }

    public double largestSumOfAverages(int[] A, int K) {
        Arrays.sort(A);
        double sum = 0;
        for (int i =K,j=A.length-1; i >1; i--,j--) {
            sum = sum + A[j];
        }
        int sumOther = 0;
        for (int i = 0; i < A.length-K+1; i++) {
            sumOther = sumOther + A[i];
        }
        System.out.println(sum);
        System.out.println(sumOther);
         sum = sum + (double)sumOther / (A.length - (K - 1));
        return (double) sum;

    }
}