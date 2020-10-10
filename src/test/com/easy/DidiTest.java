package com.easy;

import java.util.HashMap;

public class DidiTest {
    public static void main(String[] args) {
        DidiTest didiTest = new DidiTest();
        System.out.println(didiTest.mostReap(new int[]{1,2,3,4, 4,5 ,5,5}));
    }


    public int mostReap(int[] arr){
//        int demo = arr.length%2==0?arr.length/2:arr.length*21d
//
//        return  arr[arr.length%2 ==0]
        if (arr.length == 0) return -1;


        int reslut = arr[0];
        int max = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i :arr){
            if (map.get(i) != null){
                // max i
                //max = max>map.get(i)+1?max:map.get(i)+1;
                if (max <= map.get(i)+1){
                    max = map.get(i)+1;
                    map.put(i,map.get(i)+1);
                    reslut  = i;
                }
            }
            else {
                map.put(i,1);
            }
        }
        return reslut;
    }
}
