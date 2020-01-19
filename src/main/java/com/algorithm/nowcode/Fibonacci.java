package com.algorithm.nowcode;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Fibonacci {

    public int fibonacci(int n) {
        if (n == 0) return  0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int sum = 0;
        if (n >2){
            sum = fibonacci(n-1)+fibonacci(n-2);
        }

        return sum;
    }
}