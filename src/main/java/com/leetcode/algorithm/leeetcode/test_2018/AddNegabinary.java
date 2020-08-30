//package com.algorithm.leeetcode.test_2018;
//
//import java.util.Arrays;
//
//public class AddNegabinary {
//    private static  int CONSTVALUE = -2;
//    public int[] addNegabinary(int[] arr1, int[] arr2) {
//        double resultOne = 0;
//        double resultTwo = 0;
//        for (int i =0;i<arr1.length;i++){
//            resultOne = resultOne+Math.pow(CONSTVALUE, arr1.length-i);
//        }
//        for (int i =0;i<arr2.length;i++){
//            resultTwo = resultTwo+Math.pow(CONSTVALUE, arr2.length-i);
//        }
//        double result =resultOne+resultTwo;
//        long j = Double.doubleToLongBits(result);
//        return longToByte8(j);
//        System.out.println(Arrays.result);
//
//
//    }
//}