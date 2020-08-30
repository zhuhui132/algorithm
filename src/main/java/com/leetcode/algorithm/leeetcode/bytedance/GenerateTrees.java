package com.leetcode.algorithm.leeetcode.bytedance;

import com.leetcode.algorithm.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class GenerateTrees {
    public static void main(String[] args) {
        GenerateTrees generateTrees = new GenerateTrees();
        generateTrees.generateTrees(3);
    }
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<TreeNode>();
        return generateTrees(1, n);

    }

    public List<TreeNode> generateTrees(int start, int end) {
        // 为什么用这个类型
        List<TreeNode> allTree = new LinkedList <>();
        if (start > end){
            return allTree;
        };

        for (int i = start;i <= end;i++){
            List<TreeNode> leftTrees = generateTrees(start,i-1 );

            List<TreeNode> rightTrees = generateTrees(i+1,end);

            //为什么这么操作
            for (TreeNode left:leftTrees){
                for (TreeNode right:rightTrees){
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTree.add(currTree);
                }
            }
        }
        return  allTree;


    }
}