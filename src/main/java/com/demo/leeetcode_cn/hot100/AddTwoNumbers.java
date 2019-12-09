package com.demo.leeetcode_cn.hot100;

import com.demo.common.ListNode;

import java.util.LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(new AddTwoNumbers().addTwoNumbers(l1, l2));


        System.out.println(new AddTwoNumbers().addTwoNumbers(new ListNode(0), new ListNode(0)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1,q = l2,curr = dummyHead;

        int carry = 0;

        while (p != null || q != null){
            int x = (p!=null)?p.val:0;
            int y = (q!=null)?q.val:0;
            int sum = carry+x+y;
            carry = sum / 10;


            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if (p !=null ) p = p.next;
            if (q !=null ) q = q.next;

        }
        if(carry>0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
//      int value =  value(l1)+value(l2);
//        System.out.println(value);
//
//      //807   7  0 8
//
//        ListNode result  = new ListNode(value/100);
//        result.next = new ListNode((value-(value/100*100))/10);
//        result.next.next = new ListNode(value%10 );
//        return  result;
//
//
//
//      //  System.out.println(sb.toString());
//    }
//
//
//    public int value(ListNode l1){
//        if(l1== null) return  0;
//        int result = 0;
//        int tem = 1;
//        while (l1 != null){
//
//            int val = l1.val*tem;
//            result = result+val;
//            tem = tem*10;
//            l1 = l1.next;
//        }
//        System.out.println(result);
//        return result;
//    }
//}
    }
}