//package com.leetcode;
//
//import java.util.*;
//
//public class ContainsDuplicate {
//    public boolean containsDuplicate(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap <>();
//
//
//        for (Integer i :nums){
//        Integer count = map.get(i);
//        count = count==null?1:++count;
//        map.put(i,count );
//        }
//
//
//        for (Integer i:map.keySet()){
//            Integer count = map.get(i);
//            if (count == 1) {return i};
//        }
//
//        return -1;
//    }
//
//
//
////        for (int i : nums) {
////            if (map.keySet().contains(i)) {
////
////                map.put(i, map.get(i) + 1);
////            } else map.put(i, 1);
////        }
////
////        Iterator iter = map.entrySet().iterator();
////        while (iter.hasNext()) {
////            Map.Entry entry = (Map.Entry) iter.next();
////            Object key = entry.getKey();
////            Object val = entry.getValue();
////            if ((Integer)val ==1){
////                return key;
////            }
////            return null;
////        }
////
////        return null;
////    }
//
//
////        for (int i = 0; i < nums.length; i++) {
////            for (int j =i+1; j < nums.length; j++) {
////                if (nums[i] == nums[j]){
////                    return true;
////                }
////            }
////        }
////        return false;
////    }
////        Set<Integer> set = new HashSet <>();
////
////
////        for (int i :nums){
////        if (set.contains(i)){
////            return true;
////        }
////        else set.add(i);
////        }
////        return false;
////    }
////
////
////
//}