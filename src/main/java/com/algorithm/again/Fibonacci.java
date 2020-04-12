package com.algorithm.again;

public class Fibonacci {
    public int fibonacci(int n) {
        if ( n == 0 ) return  0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int sum = 0;
        if (n >2){
            sum = fibonacci(n-1)+fibonacci(n-2);
        }

        return sum;
    }
}