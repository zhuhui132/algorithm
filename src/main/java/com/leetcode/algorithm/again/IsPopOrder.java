package com.leetcode.algorithm.again;

import java.util.Stack;

public class IsPopOrder {
    public static void main(String[] args) {
        IsPopOrder isPopOrder = new IsPopOrder();
        isPopOrder.isPopOrder(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2});
    }
    public boolean isPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) return false;
        Stack<Integer> st = new Stack<Integer>();


        int popIndex = 0;
        for (int i =0;i<pushA.length;i++){
            st.push(pushA[i]);

            while (!st.isEmpty() && st.peek() == popA[popIndex]){
                st.pop();
                popIndex++;
            }
        }
        return st.empty();
    }
//        int i = 0;
//        int j = 0;
//        st.push(pushA[i++]);
//        while(j <= popA.length-1){
//            while(popA[j] != st.peek()){
//                if(i == pushA.length) return false;
//                st.push(pushA[i++]);
//            }
//            j++;
//            st.pop();
//        }
//        return true;
//    }
//


}