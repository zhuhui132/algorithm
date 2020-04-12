package com.algorithm.again;

import com.algorithm.common.TreeNode;

import java.util.Arrays;

public class ReConstructBinaryTree {
    public static void main(String[] args) {

    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        TreeNode node = new TreeNode(pre[0]);


        for (int i = 0; i < in.length; i++) {
            if (in[i] == node.val){
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                // 左子树，注意 copyOfRange 函数，左闭右开
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                // 右子树，注意 copyOfRange 函数，左闭右开
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }

        return node;
    }
}
