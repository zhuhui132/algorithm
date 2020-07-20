package com.algorithm.leeetcode_cn.bytedance;

public class Flatten {
    public void flatten(Treenode root){
        if (root == null) return;

        flatten(root.left);

        flatten(root.right);

        Treenode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = tmp;
    }
}
