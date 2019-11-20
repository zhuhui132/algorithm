package com.demo.nowcode;

import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[] array = new  int[]{3,4,5,1,2};

        System.out.println(new Main().minNumberInRotateArray(array));
        int[] array1 = new  int[]{};
        System.out.println(new Main().minNumberInRotateArray(array1));
        int[] array2 = new  int[]{3,4,5,1,2,-4};
        System.out.println(new Main().minNumberInRotateArray(array2));
        int[] array3 = new  int[]{3,4,5,1,2,1,1};
        System.out.println(new Main().minNumberInRotateArray(array3));
    }
    public int minNumberInRotateArray(int [] array) {
        if (array.length <= 0) return 0;
        Arrays.sort(array);
        return array[0];
   
   }
}