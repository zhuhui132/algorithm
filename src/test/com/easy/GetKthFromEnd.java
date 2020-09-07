package com.easy;

public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head,last = head;
        while (k >0 && first != null){
            first = first.next;
            k--;
        }
        while (first !=null){
            first = first.next;
            last = last.next;
        }
        return last;
    }
}
