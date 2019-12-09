//package com.demo.leeetcode_cn;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class FirstMissingPositive {
//    public static void main(String[] args) {
//        int [] nums  = new int[]{1,2,0};
//        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
//        System.out.println(firstMissingPositive.firstMissingPositive(nums));
//
//    }
//    public int firstMissingPositive(int[] nums) {
//        if (nums.length == 0 )return 0;
//        ArrayList <Integer> list = new ArrayList <>();
//        for (int o : nums) { if (o > 0) { list.add(o); } }
//
//        int[] intArr = list.stream().mapToInt(Integer::intValue).toArray();
//
//        Arrays.sort(intArr);
//
//        for (int i = 0 ; i<intArr.length-1;i++){
//            // 判断最小值的大小
//            if (intArr[0] >1){
//                return 1;
//            }
//            if((intArr[i]+1)!= intArr[i+1]){
//                return intArr[i]+1;
//            }
//        }
//        return  0;
//    }
//}