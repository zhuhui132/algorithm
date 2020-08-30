package com.leetcode.algorithm.leeetcode.goldreview;

import com.leetcode.algorithm.common.ListNode;

public class DeleteNode {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(5).next = new ListNode(1).next = new ListNode(9);

        DeleteNode deleteNode = new DeleteNode();
        deleteNode.deleteNode(node);


    }

    public void deleteNode(ListNode node){
        while(node!=null)
        {
            node.val=node.next.val;

            if(node.next.next==null)
            {
                node.next=null;

                break;
            }
            node=node.next;

        }
    }
}
