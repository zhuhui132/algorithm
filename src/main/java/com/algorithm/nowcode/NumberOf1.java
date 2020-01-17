package com.algorithm.nowcode;

public class NumberOf1 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(-3));
        System.out.println(NumberOf1(3));
        System.out.println(Integer.bitCount(-3));
    }
    public static int NumberOf1(int n) {
        int t=0;
        char[]ch=Integer.toBinaryString(n).toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='1'){
                t++;
            }
        }
        return t;
    }
}