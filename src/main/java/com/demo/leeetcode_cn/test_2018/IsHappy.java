package com.demo.leeetcode_cn.test_2018;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        isHappy.isHappy(19);
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(n != 1){
            n = change(n);
            if(set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

    public int change(int n){
        int sum = 0;
        int num;
        while(n != 0){
            num = n%10;
            n /= 10;
            System.out.println(n);
            sum += num*num;

        }
        return sum;
    }

}