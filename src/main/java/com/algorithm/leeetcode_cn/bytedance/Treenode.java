package com.algorithm.leeetcode_cn.bytedance;

public class Treenode {
    int val;
    Treenode left;
    Treenode right;
    Treenode(int val){
        this.val = val;
    }
    Treenode(int val,Treenode left,Treenode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
