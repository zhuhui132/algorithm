package com.algorithm.again;

import com.algorithm.common.TreeNode;

public class Convert {
    public static void main(String[] args) {
        Convert convert = new Convert();

    }
    TreeNode head = null;
    TreeNode realHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return  realHead;
    }

    public void ConvertSub(TreeNode pRootOfTree){
        if(pRootOfTree==null) {
            return;
        }
        ConvertSub(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }
}
