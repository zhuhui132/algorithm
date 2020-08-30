package com.leetcode.algorithm.again;

public class Ha {
    public static void main(String[] args) {
        int i =1;
        System.out.println(i);
        int b = i++;
        // b = i
        // i = i+1
        // 先赋值，再自增
        System.out.println(b);
        System.out.println(i);

        // 先自增，再赋值
        // i = i+1
        // c = i;
        int c = ++i;
        System.out.println(c);
        System.out.println(i);

    }

}
