package com.demo.leeetcode_cn;

public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) return  null;
        return String.valueOf(Integer.valueOf(num2)*Integer.valueOf(num1));

    }
}
