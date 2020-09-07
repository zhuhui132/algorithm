package com.easy;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode cur =null,pre = head;
        while (pre!=null){
            ListNode tmp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tmp;

        }
        return cur;
    }
}