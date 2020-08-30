package com.leetcode.algorithm.leeetcode.goldreview;

import com.leetcode.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthLargest {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList <>();
        helper(root,list );
        return list.get(list.get(list.size()-k));

    }


    public void helper(TreeNode root , List<Integer> list){
        if (root  == null) return ;
        if (root.left !=null){
            helper(root.left, list);
        }
        list.add(root.val);
        if (root.right !=null){
            helper(root.right,list );
        }
    }
}