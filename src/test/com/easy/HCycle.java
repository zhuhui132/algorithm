package com.easy;

public class HCycle {
    /**
     * 怎么判断break;
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {


        if ( head== null|| head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null&&fast !=null &&fast.next!=null && fast.next.next !=null ){
            slow =slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return  true;
            }
        }
        return false;

    }
}
