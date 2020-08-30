package com.leetcode.algorithm.leeetcode.BinaryTreeNode;

import com.leetcode.algorithm.common.TreeNode;

import java.util.*;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        //node.left = new TreeNode(9);
        node.right= new TreeNode(20).left = new TreeNode(15);
        node.right.right= new TreeNode(7);

        LevelOrder levelOrder = new LevelOrder();
        levelOrder.levelOrderAsZ(node);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList <>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) queue.add(root);
        while( !queue.isEmpty() ){
            List<Integer> list = new ArrayList <>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(list);

        }
        return result;
    }

    public int[] levelOrder2(TreeNode root) {
        List<Integer> list = new ArrayList <>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[]  result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    //Java 中将链表 LinkedList 作为双端队列使用。
    public List<List<Integer>> levelOrderAsZ(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;

    }

    public List<List<Integer>> levelOrderAsZUseStack(TreeNode root) {
        List<List<Integer>> res = new ArrayList <>();
        Stack<TreeNode> s1 = new Stack <>();
        Stack<TreeNode> s2 = new Stack <>();


        if (root != null) s1.add(root);

        boolean flag = true;
        while ( !s1.isEmpty() || !s2.isEmpty()){
            List<Integer> tmp = new ArrayList <>();
            if (flag){
                while (!s1.isEmpty()){
                    TreeNode node = s1.pop();
                    tmp.add(node.val);
                    if (node.left != null) s2.add(node.left);
                    if (node.right != null) s2.add(node.right);
                }
            }
            else {
                while (!s2.isEmpty()){
                    TreeNode node = s2.pop();
                    tmp.add(node.val);
                    if (node.left != null) s1.add(node.left);
                    if (node.right != null) s1.add(node.right);
                }
            }
            res.add(tmp);
            flag =!flag;
        }
        return res;
    }


}





