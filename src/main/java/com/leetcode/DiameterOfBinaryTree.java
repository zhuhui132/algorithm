//package com.leetcode;
//
//public class DiameterOfBinaryTree {
//    public static int max = 0;
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right= new TreeNode(3);
//
//        root.left .left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        int fina = diameterOfBinaryTree(root);
//        System.out.println(fina);
//    }
//
////     public int max = 0;
////     public int diameterOfBinaryTree(TreeNode root) {
////      if (root != null){
////          setDepth(root);
////          return max;
////      }
////      return 0;
//
//
////     }
//
//
//
//
////     public int setDepth(TreeNode root){
////         if (root != null){
////             int right = setDepth(root.right);
////             int left = setDepth(root.left);
////             if (right + left> max){
////                 max = right + left;
////                 return Math.max(right ,left)+1;
////             }
////         }
////         return 0;
////     }
//// }
//
//
//
//        public static int diameterOfBinaryTree(TreeNode root) {
//            if (root != null) {
//                //遍历每一个节点,求出此节点作为根的树的深度,那么,左子树深度加右子树深度的最大值即是答案
//                setDepth(root);
//                return max;
//            }
//            return 0;
//        }
//
//        public static  int setDepth(TreeNode root) {
//            if (root != null) {
//                int right = setDepth(root.right);
//                int left = setDepth(root.left);
//                if (right + left > max){
//                    max = right + left;
//                }
//                return Math.max(right, left) + 1;
//            }
//            return 0;
//        }
//    }
