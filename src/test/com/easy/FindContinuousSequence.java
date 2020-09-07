package com.easy;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();

        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        while (i < target/2){
            if (sum <target){
                sum +=j;
                j++;
            }
            else if (sum >target){
                sum -=i;
                i++;
            }
            else {
                int[] arr = new int[j-i+1];
                for (int k =i;k<j ;k++){
                    arr[k-i] = k;
                }

                res.add(arr);
                sum -=i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    public int[][] findContinuousSequencetw(int target) {
        List<int[]> list = new ArrayList<>();
        for (int l=1,r =1,sum = 0;r <target/2+1;r++){
            sum = sum +r;
            while (sum >target){
                sum -=l ++;
            }
            if (sum ==target){
                int[] temp = new int[r-l+1];
                for (int i =0;i<temp.length;i++){
                    temp[i] = i+1;
                }
                list.add(temp);
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }


}