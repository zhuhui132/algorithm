package main.java.com.company.dem.list;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListFromTailToHead {

    public static void main(String[] args) {
//        PrintListFromTailToHead printListFromTailToHead = new PrintListFromTailToHead();
//
//        printListFromTailToHead.printListFromTailToHead()
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        Stack stack = new Stack();
//
//        if (listNode.next != null){
//            stack.push(listNode.val);
//        }
//
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        while (stack.pop()!=null){
//            arrayList.add((Integer)stack.firstElement());
//        }
//
//
//        return  arrayList;
//    }
//}
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        ListNode temp = listNode;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }
}

 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

