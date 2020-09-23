package com.middle;

import com.easy.TreeNode;

import java.util.Stack;

public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) return ;

        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = tmp;
    }

//
//        Stack<TreeNode> stack  = new Stack<>();
//
//        while(root.left != null){
//            TreeNode temp  = root.right;
//            if ( root.right !=null){
//                stack.push(temp);
//            }
//            root.left = root.right;
//        }
//
//    }
}