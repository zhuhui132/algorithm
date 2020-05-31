package com.algorithm.again;

import com.algorithm.common.ListNode;

public class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode phead1,ListNode phead2){
        if (phead1 == null || phead2 == null) return null;
        ListNode p1 = phead1;
        ListNode p2 = phead2;
        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2){
                if (p1 == null) p1 = phead2;
                if (p2 == null) p2 = phead1;
            }
        }
        return p1;
    }
}
