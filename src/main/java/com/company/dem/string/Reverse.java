package com.company.dem.string;

public class Reverse {
    public static void main(String[] args) {

    }
    public  int reverse(int x) {
        int value = 0;
        int pre = 0;

        while (x!=0){
            value = value*10 +x%10;
            x = x/10;
        }
        return checkValid(pre,value);

    }

    public int checkValid(int num1,int num2){
       return 0;

    }
}
