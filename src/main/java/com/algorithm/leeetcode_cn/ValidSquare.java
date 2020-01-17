//package com.algorithm.leeetcode_cn;
//
//import java.util.Arrays;
//
///**
// * https://leetcode-cn.com/problems/valid-square/solution/you-xiao-de-zheng-fang-xing-by-leetcode/
// */
//public class ValidSquare {
//    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
//        if (p1.length == 0 || p2.length == 0 || p3.length == 0 || p4.length ==0 )return false;
//
//        if (p1.length != 2 || p2.length != 2 || p3.length != 2 || p4.length != 2)
//            return false;
//        int[][] points = {p1, p2, p3, p4};
//        double[][] results = new double[4][3];
//        for (int i =0;i<points.length ;i++){
//            for (int j = 0 ;j<points.length;j++){
//                results[i][j] = lengthOf(points[i],points[j] );
//            }
//        }
//        for (double[] result:results){
//            Arrays.sort(result);
//        }
//
//
//        for (int i =0;i<results.length;i++){
//            for (int j =0;j<results[0].length-1;j++){
//                if (results[i][j]!= results[i][j+1]){
//                    return false;
//                    break;
//                }
//            }
//        }
//
//
//
//    }
//    private static double lengthOf(int[] a, int[] b){
//        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
//    }
//}