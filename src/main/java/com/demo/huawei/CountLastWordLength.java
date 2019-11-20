package com.demo.huawei;

import java.util.Scanner;

public class CountLastWordLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(str);
            System.out.println(getLength(str));
        }

    }


    public static int getLength(String str){
        String[] strs = str.split(" ");
        return strs[strs.length-1].length();
    }
}
