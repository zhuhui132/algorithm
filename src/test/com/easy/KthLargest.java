package com.easy;

import java.util.ArrayList;
import java.util.List;

public class KthLargest {
    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list.get(list.size()-k);
    }

    public void helper(TreeNode root ,List<Integer> list){
        if (root == null) return;
        if (root.left !=null) helper(root.left,list);
        list.add(root.val);
        if (root.right !=null) helper(root.right,list);
    }
}