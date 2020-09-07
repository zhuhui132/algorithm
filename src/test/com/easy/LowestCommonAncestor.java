package com.easy;


public class LowestCommonAncestor {


    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)return null;
        if (root == p || root == q ){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p ,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right !=null){
            return root;
        }
        if (left!=null){
            return left;
        }
        if (right != null){
            return right;
        }
        return null;
    }


    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor2(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor2(root.right, p, q);

        return root;
    }
}
