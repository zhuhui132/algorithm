package com.easy;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode h1 = headA, h2 = headB;
        while (h1 != h2) {

            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }

        return h1;
    }
}