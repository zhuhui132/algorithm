package com.algorithm.again;

import com.algorithm.common.TreeNode;

public class Mirror {
    public void Mirror(TreeNode root) {
        if (root == null) return ;
        TreeNode temp ;
        if (root != null){
            temp =root.right;
            root.right = root.left;
            root.left = temp;

            if(root.left!=null)
                Mirror(root.left);
            if(root.right!=null)
                Mirror(root.right);
        }
    }

}

