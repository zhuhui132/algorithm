package com.demo.leeetcode_cn.test_2018;

public class BitwiseComplement {
    public static void main(String[] args) {
        BitwiseComplement b = new BitwiseComplement();
        System.out.println(b.bitwiseComplement(5));


    }

    public int bitwiseComplement(int N) {
        String str = Integer.toBinaryString(N);
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i<str.length();i++){
            if ("0".equals(String.valueOf(str.charAt(i)))){
                sb.append(1);
            }
            else sb.append(0);
        }


        return Integer.valueOf(sb.toString());
    }
}