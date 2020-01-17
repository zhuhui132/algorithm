package com.algorithm.leeetcode_cn.test_2018;

import com.algorithm.common.ListNode;

public class IsPalindromeList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(4);
        IsPalindromeList isPalindromeList = new IsPalindromeList();
        isPalindromeList.isPalindrome(listNode);
    }
    public boolean isPalindrome(ListNode head) {
        // 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 根据快慢指针，找到链表的中点
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow.next);
        while(slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        // 递归到最后一个节点，返回新的新的头结点
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}








//        List<Integer> listNodes = new ArrayList <>();
//        Stack<Integer> stack = new Stack <>();
//        while (head != null){
//            listNodes.add(head.val);
//            stack.push(head.val);
//            head = head.next;
//        }
//        Integer[] result  = (Integer[])listNodes.toArray(new Integer[listNodes.size()]);
//        Stack<Integer> stack2 = new Stack <>();
//        while (stack.size() != 0){
//            stack2.push(stack.peek());
//            stack.pop();
//        }
//        Integer[] reslt2 = stack2.toArray(new Integer[listNodes.size()]);
//        for (int i =0;i<listNodes.size();i++){
//            System.out.println(result[i]  + "------"+reslt2[i]);
//        }
//        return false;
//
//    }
