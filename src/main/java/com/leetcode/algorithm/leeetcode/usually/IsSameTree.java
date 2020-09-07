package com.leetcode.algorithm.leeetcode.usually;

import com.leetcode.algorithm.common.TreeNode;

public class IsSameTree {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}