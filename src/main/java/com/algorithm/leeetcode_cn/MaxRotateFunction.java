package com.algorithm.leeetcode_cn;

import java.util.Arrays;

public class MaxRotateFunction {
    public static void main(String[] args) {
        int[] demo = new int[]{-2147483648,-2147483648};
        System.out.println(new MaxRotateFunction().maxRotateFunction(demo));

    }
    public int maxRotateFunction(int[] A) {

        if (A.length == 0) {
            return  0;
        }
        //

        int[] b = new int[A.length+A.length-1];

        System.arraycopy(A,0 ,b ,0 ,A.length );
        System.arraycopy(A,0 ,b ,A.length ,A.length-1 );
        // [4, 3, 2, 6 ,4 ,3 ,2]
        for (int i: b) {
            System.out.println("i"+i); }
        int[] arrys = new int[A.length];

        for (int i =0;i<=A.length-1;i++){
            int count =1;
            for ( int j = i+1;j<=i+A.length-1;j++){

                arrys[i] = count *b[j] + arrys[i];
                count++;
            }
        }

        //
        for (int i: arrys) {
            System.out.println(i); }
        Arrays.sort(arrys);
        return arrys[arrys.length-1];
    }
}