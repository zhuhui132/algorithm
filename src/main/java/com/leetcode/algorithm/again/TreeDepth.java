package com.leetcode.algorithm.again;

import com.leetcode.algorithm.common.TreeNode;

public class TreeDepth {
    public int treeDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDept = treeDepth(root.left);
        int rightDept  = treeDepth(root.right);

        int result = 1+(leftDept >rightDept?leftDept:rightDept);
        return result;
    }
}