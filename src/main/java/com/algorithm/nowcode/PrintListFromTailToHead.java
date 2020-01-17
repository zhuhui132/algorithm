package com.algorithm.nowcode;

import com.algorithm.common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {
    public static void main(String[] args) {
        //{67,0,24,58}
        ListNode listNode = new ListNode(67);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(24);
        listNode.next.next.next = new ListNode(58);
        printListFromTailToHead(listNode);
    }
    public static  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack <>();
        while (listNode !=null ){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        for (Integer i:stack ) {
            System.out.println(i);

        }
        ArrayList<Integer> list = new ArrayList <>();
        while (stack.size() !=0){
            Integer i = stack.pop();
            list.add(stack.pop());

        }
        return list;

    }
}