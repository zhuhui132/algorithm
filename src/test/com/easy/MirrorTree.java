package com.easy;

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode node = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(node);
        return  root;
    }
}
