package com.demo.leeetcode_cn.test_2018;

public class GetSum {
    public static void main(String[] args) {
    }


    public int getSum(int a, int b) {
        while (b !=0 ){
            int temp = a^b;
            b = (a & b)<<1;
            a=temp;
        }
        return a;
    }
}