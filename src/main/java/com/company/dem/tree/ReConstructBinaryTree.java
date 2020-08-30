//package com.company.dem.tree;
//
//import java.util.ArrayList;
//
////二叉树遍历分为三种：前序、中序、后序，其中序遍历最为重要。
//// 为啥叫这个名字？
//// 是根据根节点的顺序命名的。
//public class ReConstructBinaryTree {
//    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
//        TreeNode treeNode = new TreeNode();
//
//        int RootIndex = 0;
//
//
//        //获取根节点在中序遍历数组中是位置
//        for (int i = 0; i < in.length; i++) {
//            if (in[i] == pre[0]) {
//                RootIndex = i;
//            }
//        }
//
//
////去掉根节点
//        //int[] pre2=new int[pre.length-1];
//        int[] preLeft = new int[RootIndex];
//        int[] preRight = new int[pre.length - RootIndex - 1];
//
//        for (int i = 0; i < RootIndex; i++) {
//            preLeft[i] = pre[i + 1];
//        }
//        for (int i = 0; i < pre.length - RootIndex - 1; i++) {
//            preRight[i] = pre[RootIndex + 1 + i];
//        }
//
//
//        //将中序的遍历的结果分为两份，一份是左节点，一份是右节点
//        int[] leftArray = new int[RootIndex];
//        int[] rightArray = new int[in.length - RootIndex - 1];
//        ArrayList<Integer> leftList = new ArrayList<Integer>();
//        ArrayList<Integer> rightList = new ArrayList<Integer>();
//
//        for (int i = 0; i < RootIndex; i++) {
//            leftArray[i] = in[i];
//            leftList.add(in[i]);
//        }
//
//        for (int i = 0; i < in.length - RootIndex - 1; i++) {
//            rightArray[i] = in[RootIndex + i + 1];
//            rightList.add(in[RootIndex + i + 1]);
//        }
//
//
//        if (in.length > 0 & pre.length > 0) {
//            if (preLeft.length > 0) {
//                treeNode.left = reConstructBinaryTree(preLeft, leftArray);
//            }
//            if (preRight.length > 0) {
//                treeNode.right = reConstructBinaryTree(preRight, rightArray);
//            }
//        }
//
//
//        return treeNode;
//    }
//}
//
//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(){
//        this.val = val;
//    }
//}