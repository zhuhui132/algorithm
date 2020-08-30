package com.leetcode.algorithm.leeetcode.usually;

import com.leetcode.algorithm.common.TreeNode;

import java.util.*;

public class PrintAsZ {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(4);
        node.right = new TreeNode(2);

        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(7);


        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(8);

        node.right.right.left = new TreeNode(9);
        node.right.right.right = new TreeNode(99);


        System.out.println(new PrintAsZ().levelOrder(node));
        System.out.println(new PrintAsZ().levelOrder2(node));

    }


    //[[3],[9,20],[15,7]]
    public List <List <Integer>> levelOrder(TreeNode root) {
        List <List <Integer>> aList = new ArrayList <>();
        if (root == null) {
            return aList;
        }
        Queue <TreeNode> queue = new LinkedList <>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List <Integer> list = new ArrayList <>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode tem = queue.poll();
                list.add(tem.val);
                if (tem.left != null) {
                    queue.add(tem.left);
                }
                if (tem.right != null) {
                    queue.add(tem.right);
                }

            }
            aList.add(list);
        }
        return aList;
    }


    //[[3],[9,20],[15,7]]
    public List <List <Integer>> levelOrder2(TreeNode root) {
        List <List<Integer>> aList = new ArrayList <>();
        if (root == null) {
            return aList;
        }
        Queue <TreeNode> queue = new LinkedList <>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List <Integer> list = new ArrayList <Integer>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode tem = queue.poll();
                list.add(tem.val);
                if (tem.left != null) {
                    queue.add(tem.left);
                }
                if (tem.right != null) {
                    queue.add(tem.right);
                }

            }
            aList.add(list);
        }

        for(int i = 1;i<aList.size();){
            Collections.reverse(aList.get(i));

            i = i+2;
        }
        return aList;
    }
}