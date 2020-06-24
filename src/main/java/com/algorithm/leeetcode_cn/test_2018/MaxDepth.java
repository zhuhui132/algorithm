//package com.algorithm.leeetcode_cn.test_2018;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//
//public class MaxDepth {
//    public int maxDepth(Node root) {
//        if (root == null) return 0;
//        int depth =0;
//        for (int i = 0; i < root.children.size(); i++) {
//            depth = Math.max(depth,maxDepth(root.children.get(i)) );
//        }
//        return depth+1;
//    }
//
//
//    public int maxDepth2(Node root){
//        if (root == null){
//            return 0;
//        }
//        int depth = 0
//        if (root.children.size() == 0) return 1;
//        Queue<Node> queue = new LinkedList <>();
//
//        queue.add(root);
//        while (!queue.isEmpty()){
//            int count = queue.size();
//            depth++;
//            while (count>0){
//                Node node = queue.poll();
//                if (node.children.size() != 0){
//                    ((LinkedList<Node>) queue).addAll(node.children );
//                }
//                count--;
//            }
//        }
//        return depth;
//
//    }
//
//    private  class Node {
//        public int val;
//        public List<Node> children;
//
//        public Node() {}
//
//        public Node(int _val) {
//            val = _val;
//        }
//
//        public Node(int _val, List<Node> _children) {
//            val = _val;
//            children = _children;
//        }
//    };
//}