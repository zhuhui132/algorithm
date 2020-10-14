package com.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSFlevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null){
            queue.add(root);
        }

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size();i>0;i--){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right !=null){
                    queue.add(node.right);
                }
                res.add(list);
            }
        }
        return res;
    }
}