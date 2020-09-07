package com.easy;


import java.util.LinkedList;
import java.util.List;

//剑指 Offer 55 - I. 二叉树的深度
public class MaxDepth {
    /**
     * 方法一：后序遍历（DFS）
     * 树的后序遍历 / 深度优先搜索往往利用 递归 或 栈 实现，本文使用递归实现。
     * 关键点： 此树的深度和其左（右）子树的深度之间的关系。显然，此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1+1 。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/solution/mian-shi-ti-55-i-er-cha-shu-de-shen-du-xian-xu-bia/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return  0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.left))+1;
    }

    public int maxDepthBSF(TreeNode root) {
        if (root == null){
            return  0;
        }
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> tmp ;
        int res = 0;
        while (!queue.isEmpty()){
            tmp = new LinkedList<>();

            for (TreeNode node :queue){
                if (node.left != null){
                    tmp.add(node.left);
                }
                if (node.right != null){
                    tmp.add(node.right);
                }
            }
            queue = tmp;
            res++;

        }
        return res;

    }
}
