package com.demo.leeetcode_cn;

import com.demo.common.ListNode;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        MiddleNode middleNode = new MiddleNode();
        middleNode.middleNode(listNode);


    }
    // 12345  取 3  5/2 =3
    // 123456 取 4  6/2 +1
    public ListNode middleNode(ListNode head) {
        ListNode p  = head;
        if (head == null) {
            return  p;
        }
        int count = 0;
        while(p !=null ){
            count++;
            p = p.next;
        }
        p=head;
        if (count%2==1){
            int j = 0;
            while(j<  count/2){
                p = p.next;
                j++;

            }
            return p;

        }
        else {
            int j = 1;
            while(j<(count/2+1)){
                p = p.next;
                j++;

            }
            return p;
        }


    }
}