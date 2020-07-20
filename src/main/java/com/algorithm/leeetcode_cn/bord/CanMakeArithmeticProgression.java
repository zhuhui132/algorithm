package com.algorithm.leeetcode_cn.bord;

import java.util.Arrays;

public class CanMakeArithmeticProgression {
    public static void main(String[] args) {
        CanMakeArithmeticProgression demo = new CanMakeArithmeticProgression();
        demo.canMakeArithmeticProgression(new int[]{3,5,1});

    }
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        Boolean flag = true;
//        for (int i = 0,j=arr.length-1; i < j ; i++,j--) {
//            if (( arr[i]+arr[j]) != (arr[i+1]+arr[j-1])){
//                flag = false;
//                break;
//            }
//        }
        int i =0;
        int j = arr.length-1;
        while (i < j){
            if (( arr[i]+arr[j]) != (arr[i+1]+arr[j-1])){
                flag = false;
                break;
            }else {
                i++;
                j--;
            }

        }
        return false;
    }
}
