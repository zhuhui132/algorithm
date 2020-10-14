package com.leetcode.algorithm.leeetcode.bytedance;

import java.util.*;

public class AdvantageCount {
    public int[] advantageCount(int[] A, int[] B) {
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);

        // assigned[b] = list of a that are assigned to beat b
        Map<Integer, Deque<Integer>> assigned = new HashMap();
        for (int b: B) assigned.put(b, new LinkedList());

        // remaining = list of a that are not assigned to any b
        Deque<Integer> remaining = new LinkedList();

        // populate (assigned, remaining) appropriately
        // sortedB[j] is always the smallest unassigned element in B
        int j = 0;
        for (int a: sortedA) {
            if (a > sortedB[j]) {
                assigned.get(sortedB[j++]).add(a);
            } else {
                remaining.add(a);
            }
        }

        // Reconstruct the answer from annotations (assigned, remaining)
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; ++i) {
            // if there is some a assigned to b...
            if (assigned.get(B[i]).size() > 0)
                ans[i] = assigned.get(B[i]).pop();
            else
                ans[i] = remaining.pop();
        }
        return ans;
    }

//      //寻找大于B[i]的最小值
//        Arrays.sort(A);
//        List<Integer> list = new ArrayList <>();
//
//        for (int i:A){list.add(i);}
//
//        for (int i = 0; i < B.length; i++) {
//            A[i] = findBigMin(list, B[i]);
//        }
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] == -1) {
//                A[i] = list.get(0);
//                list.remove(0);
//            }
//        }
//        return A;
//    }
//
//
//    }
//    public int findBigMin(List<Integer> list ,int x){
//        for (Integer i :list){
//            if (i>x){
//                list.remove((Integer) i);
//                return i;
//            }
//        }
//        return  -1;
//    }

}
