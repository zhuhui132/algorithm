package com.R_B_Tree;

public class RBTree<T extends Comparable<T>> {
    public class RBTNode<T extends Comparable <T>> {
        boolean color;        // 颜色
        T key;                // 关键字(键值)
        RBTNode <T> left;    // 左孩子
        RBTNode <T> right;    // 右孩子
        RBTNode <T> parent;    // 父结点

        public RBTNode(T key, boolean color, RBTNode <T> parent, RBTNode <T> left, RBTNode <T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

    }
}
