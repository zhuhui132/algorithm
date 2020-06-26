package com.algorithm.again;

import java.util.HashSet;

public class FindNumsAppearOnce {
    public static void main(String[] args) {
        FindNumsAppearOnce findNumsAppearOnce = new FindNumsAppearOnce();
        findNumsAppearOnce.findNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5}, new  int[1],new int[1] );
    }
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashSet<Integer> set = new HashSet <>();
        for (int i :array){
            if (set.contains(i)){
                set.remove(i);
            }else set.add(i);
        }
        Integer[]  list =  set.toArray(new Integer[]{});
        num1[0]=list[0].intValue();
        num2[0]=list[1].intValue();
    }
}
