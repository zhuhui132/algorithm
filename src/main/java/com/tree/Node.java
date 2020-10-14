package com.cnblogs.tree;

public class Node {
    private Object data;    //节点数据
    private Node leftChild; //左子节点的引用
    private Node rightChild; //右子节点的引用
    //打印节点内容
    public void display(){
        System.out.println(data);
    }


//Integer可能为空，但是int不会，如果int没有赋值，则默认问0
//    public Node find(int key) {
//
//
//
//    }
 
}