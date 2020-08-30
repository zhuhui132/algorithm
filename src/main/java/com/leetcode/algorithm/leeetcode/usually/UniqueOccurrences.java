package com.leetcode.algorithm.leeetcode.usually;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueOccurrences {

    /**
     * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
     *
     * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     * @param args
     */
    public static void main(String[] args) {
        UniqueOccurrences us = new UniqueOccurrences();
        us.uniqueOccurrences(new int[]{1,2,2,1,1,3});

    }
    public boolean uniqueOccurrences(int[] arr) {
        Boolean isTrue = true;
        HashMap<Integer,Integer> map = new HashMap <>();
        HashSet<Integer> demo = new HashSet <>();
        for (int i:arr) {
            demo.add(i);
            if (map.get(i) !=null ){
                map.replace(i,map.get(i) ,map.get(i)+1 );
            }
            else map.put(i,1 );
        }

        HashSet<Integer> set = new HashSet <>();
        Integer[] temp = demo.toArray(new Integer[] {});
        for (int i :temp){
            //把
            if (set.contains(map.get(i))){
                isTrue =false;
                break;
            }else {
                set.add(map.get(i));
            }
        }

        return isTrue;
    }
}