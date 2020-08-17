package com.algorithm.leeetcode_cn.usually;

import com.algorithm.common.TreeNode;

import java.util.*;

public class PrintFromTopToBottom {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(4);
        node.right = new TreeNode(2);

        node.left .left = new TreeNode(6);
        node.left .right = new TreeNode(7);


        node.right .left = new TreeNode(4);
        node.right .right = new TreeNode(8);

        node.right .right .left = new TreeNode(9);

        System.out.println(new PrintFromTopToBottom().printFromTopToBottom(node));

        System.out.println(new PrintFromTopToBottom().dfs2(node));

        System.out.println(new PrintFromTopToBottom().dfs(node));

    }
    // 层次遍历
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList <Integer> list = new ArrayList <>();
        if (root == null) {
            return list;
        }
        Deque <TreeNode> deque = new LinkedList <TreeNode>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode t = deque.pop();
            list.add(t.val);
            if (t.left != null) {
                deque.add(t.left);
            }
            if (t.right != null) {
                deque.add(t.right);
            }
        }

        return list;
    }


    //深度遍历


    public ArrayList<Integer> dfs(TreeNode treeNode){
        ArrayList <Integer> list = new ArrayList <>();
        Stack<TreeNode> stack = new Stack <>();
        if (treeNode == null) {
            return list;
        }

        stack.push(treeNode);

        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }

            list.add(temp.val);
        }

        return list;

    }


    public List<Integer> dfs2(TreeNode root){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        List<Integer> list=new LinkedList<Integer>();

        if(root==null) {
            return list;
        }
        //压入根节点
        stack.push(root);
        //然后就循环取出和压入节点，直到栈为空，结束循环
        while (!stack.isEmpty()){
            TreeNode t=stack.pop();
            if(t.right!=null) {
                stack.push(t.right);
            }
            if(t.left!=null) {
                stack.push(t.left);
            }
            list.add(t.val);
        }
        return  list;
    }

}