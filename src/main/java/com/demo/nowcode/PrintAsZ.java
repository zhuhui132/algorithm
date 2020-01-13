package com.demo.nowcode;


import com.demo.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintAsZ {
    private List<List<Integer>> res = new ArrayList<>();
    private ArrayList<Stack<TreeNode>> stack = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = createBinaryTree();
        List<List<Integer>> result =print(root) ;
        System.out.println( print(root));
        for (List<Integer> list:result){
            for (int i :list){
                System.out.print(i+" ");
            }
        }

    }

    public static List<List<Integer>>  print(TreeNode pRoot) {
        List <List <Integer>> res = new ArrayList <List <Integer>>();
        traversal(pRoot, res, 0);
        return res;
    }


    public static void traversal(TreeNode root, List <List <Integer>> res, int level) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(new ArrayList <Integer>());
        }
//与运算符用符号“&”表示，其使用规律如下：
//两个操作数中位都为1，结果才为1，否则结果为0
        if ((level & 1) == 1) {
            res.get(level).add(0, root.val);
        } else {
            res.get(level).add(root.val);
        }

        traversal(root.left, res, level + 1);
        traversal(root.right, res, level + 1);
    }


    private static TreeNode createBinaryTree() {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(3);
        node1.left = node3;

        TreeNode node4 = new TreeNode(4);
        node1.right = node4;

        TreeNode node5 = new TreeNode(5);
        node2.left = node5;

        TreeNode node6 = new TreeNode(6);
        node2.right = node6;

        return root;
    }

//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//
//
//
//    }
//



}