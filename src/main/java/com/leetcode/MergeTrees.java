//package com.leetcode;
//
//public class MergeTrees {
//    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        // 用层次遍历 过去，再组成 树
//
//
//        // 直接 加值
//        if (t1 == null && t2 == null) {
//            return  null;
//        }
//        if (t1 == null) {
//            return t2;
//        }
//        if (t2 == null) {
//            return t1;
//        }
//        TreeNode result = new TreeNode(t1.val+t2.val);
//        result.left = mergeTrees(t1.left,t2.left );
//        result.right = mergeTrees(t1.right,t2.right );
//
//        return  result;
//
//    }
//}