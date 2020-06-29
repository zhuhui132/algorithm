package com.algorithm.common;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkList {
    public int size;
    //public int val;
    public ListNode pre;
    public ListNode next;
    public LinkList(){};

    public LinkList(int size){
        HashMap<Integer ,Integer> map = new LinkedHashMap <>();
       // this.val = val;
        this.size = size;
    }

}
