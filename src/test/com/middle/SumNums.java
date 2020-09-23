package com.middle;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumNums {
    public int sumNums(int n) {
        return n == 0 ? 0 : n + sumNums(n - 1);
        // 01  & 10  =00
        // 01 | 10 =   11
        // 01 ^10  = 00
        // 01

    }
}
