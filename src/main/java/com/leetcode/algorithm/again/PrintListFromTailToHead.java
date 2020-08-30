package com.leetcode.algorithm.again;

import com.leetcode.algorithm.common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author zhuhui9
 */
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList <>();

        Stack<Integer> stack  = new Stack <>();
        ListNode node = listNode;
        while (node != null){
            stack.push(node.val);
            node = node.next;
        }
//不同点：peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。
        while (stack.size() != 0){
            result.add(stack.peek());

        }

        return result;

    }
}