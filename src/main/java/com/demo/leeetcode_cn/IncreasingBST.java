//package com.demo.leeetcode_cn;
//
//import com.demo.common.TreeNode;
//
//import java.util.ArrayList;
//
//public class IncreasingBST {
//    ArrayList<Object> list = new ArrayList <>();
//    public TreeNode increasingBST(TreeNode root) {
//
//
//        if (root.left !=null ){
//            increasingBST(root.left);
//          //  list.add(root.left.val);
//        }
//        else {
//            list.add(null);
//        }
//        if (root.right !=null ){
//            increasingBST(root.right);
//           // list.add(root.right.val);
//        }
//        else {
//            list.add(null);
//        }twoSum
//
//            list.add(root.val);
//
//    }
//}