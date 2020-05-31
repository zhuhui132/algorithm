package com.algorithm.leeetcode_cn.test_2018;

import java.util.HashMap;
import java.util.HashSet;

public class Once {
    public static void main(String[] args) {

    }

    public int once(int[] arr){
        int result = 0;
        for (int i :arr){
           result = result^i;
       }
       return result;
    }


//    public int  findNumsAppearOnce(int [] array,int num1[] ]) {
//        HashSet<Integer> set = new HashSet <>();
//        for (int i :array){
//            if (set.contains(i)){
//                set.remove(i);
//            }else set.add(i);
//        }
//        Integer[]  list =  set.toArray(new Integer[]{});
//        num1[0]=list[0].intValue();
//       return  num1[0];
//    }
}

