package com.easy;

import java.util.Stack;

public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        if (head == null )return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null){
            stack.push(tmp);
            tmp = tmp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i=0;i<size;i++){
            print[i] = stack.pop().val;
        }
        return print;
    }
}
