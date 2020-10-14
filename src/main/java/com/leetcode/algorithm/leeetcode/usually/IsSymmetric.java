package com.leetcode.algorithm.leeetcode.usually;

import com.leetcode.algorithm.common.TreeNode;

public class IsSymmetric {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode treeNode){
        return isMirror(treeNode, treeNode);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        //  俩个 &&  &&
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}