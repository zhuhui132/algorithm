package com.algorithm.leeetcode_cn.start;


import com.algorithm.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索
 * 使用俩个队列
 */
public class PathSum {
    public static void main(String[] args) {

    }


    /**
     * Queue	Deque
     * 添加元素到队尾	add(E e) / offer(E e)	addLast(E e) / offerLast(E e)
     * 取队首元素并删除	E remove() / E poll()	E removeFirst() / E pollFirst()
     * 取队首元素但不删除	E element() / E peek()	E getFirst() / E peekFirst()
     * 添加元素到队首	无	addFirst(E e) / offerFirst(E e)
     * 取队尾元素并删除	无	E removeLast() / E pollLast()
     * 取队尾元素但不删除	无	E getLast() / E peekLast()
     *
     * @param root
     * @param value
     * @return
     */
    public boolean pathSum(TreeNode root, int value) {
        if (root == null) return false;
        //存放节点
        Queue <TreeNode> deque = new LinkedList <>();
        //存放值
        Queue <Integer> sum = new LinkedList <>();

        deque.offer(root);
        sum.offer(root.val);

        while (!deque.isEmpty()) {

            // poll
            TreeNode node = deque.poll();

            int temp = sum.poll();
            if (node.left == null && node.right == null) {
                if (temp == value) {
                    return true;
                }
                ;
                continue;

            }
            if (node.left != null) {
                deque.offer(node.left);
                sum.offer(node.left.val + temp);

            }
            if (node.right != null) {
                deque.offer(node.right);
                sum.offer(node.right.val + temp);

            }
        }
        return false;


    }
}
