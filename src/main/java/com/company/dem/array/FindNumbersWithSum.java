//package com.company.dem.array;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Set;
//
//public class FindNumbersWithSum {
//    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum){
//        HashMap<Integer,ArrayList<Integer>> result = new HashMap <Integer, ArrayList <Integer>>();
//        ArrayList<Integer> suma  = new ArrayList <Integer>();
//        int[] a = new int[2];
//        for ( int i = 0;i<array.length;i++){
//           for (int j = i+1;j<array.length;j++){
//               if ((array[i]+array[j])==sum){
//                   suma.add(array[i]);
//                   suma.add(array[j]);
//                   int key = array[i]*array[j];
//                   result.put(key,suma );
//               }
//           }
//        }
//        Set <Integer> keys = result.keySet();
//        Iterator<Integer> iter = keys.iterator() ;
//        if (iter.hasNext()){
//
//
//
//       }
//return result;
//    }
//}