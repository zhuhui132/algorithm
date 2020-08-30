//package com.leetcode;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//class Solution {
//
//
//    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(3);
//        treeNode.left=new TreeNode(9);
//        treeNode.right = new TreeNode(20);
//        treeNode.right.left = new TreeNode(15);
//        treeNode.right.right = new TreeNode(7);
//        List<List<Integer>> res = new Solution().levelOrder(treeNode);
//
//
//    }
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new LinkedList<>();
//        if (root == null) {
//            return res;
//        }
//
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<Integer> currentRes = new LinkedList<>();
//            // 当前队列的大小就是上一层的节点个数, 依次出队
//            while (size > 0) {
//                TreeNode current = queue.poll();
//                if (current == null) {
//                    continue;
//                }
//                currentRes.add(current.val);
//                // 左子树和右子树入队.
//                if (current.left != null) {
//                    queue.add(current.left);
//                }
//                if (current.right != null) {
//                    queue.add(current.right);
//                }
//                size--;
//            }
//            res.add(currentRes);
//        }
//        return res;
//    }
//}