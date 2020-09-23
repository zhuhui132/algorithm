package com.zhuhui.guava.utilites;

import com.easy.TreeNode;

public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }
}


//        TreeNode p = t1;
//        //
//        if (t2 == null && t1 ==null)return  null;
//        if (t1 != null && t2 == null) {
//           return  t1;
//        }
//        if (t1 == null && t2 !=null){
//            t1= new TreeNode(t2.val);
//            return  t1;
//        }
//
//        t1.val = t1.val+t2.val;
//
//        mergeTrees(t1.left,t2.left);
//        mergeTrees(t1.right,t2.right);
//        return p;
//    }
//}