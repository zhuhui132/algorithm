//package com.company.dem.tree;
//
//public class TreeSirea {
//
//
//    String Serialize(TreeNode root) {
//        return midOrder(root);
//    }
//
//
//    public String midOrder(TreeNode Node) {
//        StringBuffer stringBuffer = new StringBuffer();
//        if (Node != null) {
//            midOrder(Node.left);
//            System.out.print(Node.val + " ");
//            stringBuffer.append(Node.val);
//            midOrder(Node.right);
//        }
//        return stringBuffer.toString();
//    }
//    TreeNode Deserialize(String str) {
//
//    }
//}
//
//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//
//    }
//
//}