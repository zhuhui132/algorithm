package com.easy;

public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        //剑指 Offer 58 - II. 左旋转字符串
        // 学习字符串的substring 拼接，返回一个新的字符串
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}