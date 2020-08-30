package com.leetcode.algorithm.leeetcode.usually;

import java.util.ArrayList;
import java.util.List;

public class ArrayDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList <>();
        List<List<Integer>> result = new ArrayList <>();
        int a =8;
        list.add(a);
        result.add(list);
        System.out.println(result);
        a=9;
        list.add(a);
        result.add(list);
        System.out.println(result);
    }
}
//[[8], [8, 9]]
