package com.algorithm.again;

import com.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PrintFromTopToBottom {
    //从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    public ArrayList <Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList <Integer> result = new ArrayList <>();
        if (root == null) return result;
        Deque<TreeNode> deque = new LinkedList <>();
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode t = deque.pop();
            result.add(t.val);
            if(t.left != null) deque.add(t.left);
            if(t.right != null) deque.add(t.right);
        }
        return result;
    }
}