package com.easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
    public static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2).left = new TreeNode(3);


        inorderTraversal.inorderTraversal(root);
        inorderTraversal.inorderTraversal2(root);
        System.out.println(result.toString());
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();

        while (root != null || !stk.isEmpty()){
            while (root != null){
                stk.push(root);
                root = root.left;
            }

            root = stk.pop();
            res.add(root.val);
            root = root.right;

        }
        return res;
//        if (root == null) return  result;
//
//        if (root.left !=null){
//            inorderTraversal(root.left);
//        }
//        result.add(root.val);
//
//        if (root.right !=null){
//            inorderTraversal(root.right);
//        }
//        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        System.out.println(res.toString());
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
