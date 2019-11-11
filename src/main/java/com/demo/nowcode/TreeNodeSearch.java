package com.demo.nowcode;

import com.demo.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeSearch {
    public static void main(String[] args) {

    }
    //深度优先搜索（DFS）
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void DFS(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level){
            levels.add(new ArrayList<Integer>());}

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null){
            DFS(node.left, level + 1);}
        if (node.right != null){
            DFS(node.right, level + 1);}
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {return levels;}
        DFS(root, 0);
        return levels;
    }




    //宽度优先搜索（BFS）
    public List<List<Integer>> BFS(TreeNode root) {
        if (root == null){
            return new ArrayList <>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList <>();
            while (count >0 ){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                count--;
            }
            res.add(list);
        }
        return res;


    }
}
