package com.company.demo.array;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class FindKthToTail{
    public ListNode findKthToTail(ListNode head,int k){

        ListNode pre = null,p=null;

        p = head;
        pre = head;

        int a = k;
        int count = 0;

        while( p != null){
            p = p.next;
            count ++;
            if(k<1){
                pre = pre.next;
            }
            k--;

        }

        if (count <a ) {
            return null;
        }
        return pre;
    }
}
