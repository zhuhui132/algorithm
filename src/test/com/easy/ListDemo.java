package com.easy;

public class ListDemo {
    public static void main(String[] args) {

    }

    public ListNode merge(ListNode node1,ListNode node2){

        if (node1 == null) return node2;
        if (node2 == null) return node1;
        ListNode result ;
        //判断俩个链表节点大小,从小到大
        if (node1.val >= node2.val ){
            result = new ListNode(node2.val);
            //返回节点
            result.next = merge(node1,node2.next);
        }else {
            result = new ListNode(node1.val);
            result.next = merge(node1.next,node2);

        }
        return result;
    }
}
