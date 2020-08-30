//package com.leetcode;
//
//public class MergeTwoLists {
//    public ListNode result ;
//
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null ) {
//            return l2;
//        }
//        if (l2 == null ) {
//            return l1;
//        }
//        if (l1.val < l2.val ){
//            result.val = l1.val;
//            mergeTwoLists(l1.next,l2 );
//        }
//        else if (l1.val >l2.val){
//            result.val = l2.val;
//            mergeTwoLists(l1,l2.next );
//        }
//        else if (l1.val == l2.val){
//
//            result.next = new ListNode(l2.val) ;
//            mergeTwoLists(l1.next,l2.next );
//        }
//        return result;
//    }
//
//
//
//    private class ListNode{
//    int val;
//    ListNode next;
//    ListNode(int val){
//        this.val = val;
//    }
//}
//
//}