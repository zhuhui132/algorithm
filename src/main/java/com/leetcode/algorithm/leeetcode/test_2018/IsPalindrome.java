package com.leetcode.algorithm.leeetcode.test_2018;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i<s.length();i++){
            if (Character.isLetterOrDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        String str = sb.toString().toLowerCase();
        int i = 0;
        int j = str.length();
        while (i <=j ){
            if (str.charAt(i)== str.charAt(j)){
                i++;
                j--;
            }
            else {
                return false;
            }

        }
        return true;

    }
}