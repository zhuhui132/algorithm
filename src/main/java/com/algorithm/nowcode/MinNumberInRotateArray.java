package com.algorithm.nowcode;

import java.util.Arrays;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
//        if (array.length == 0 ) return  0;
//        if (array.length == 1 ) return array[0];
//
//        int i = 0;
//        int j = array.length-1;
//        while (i !=j ){
//            if (array[i]<array[j]){
//
//            }
//            else if ()
//        }
        if (array.length <= 0) {
            return 0;
        }
        Arrays.sort(array);
        return array[0];

    }

}
