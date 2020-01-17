package com.algorithm.leeetcode_cn;

import com.algorithm.common.TreeNode;

import java.util.*;

public class LevelOrder {
    public List<List<Integer>> list;
    public static void main(String[] args) {

    }
    //利用栈 存贮
    //[3,9,20,null,null,15,7],

    /**
     * 最简单的解法就是递归，首先确认树非空，然后调用递归函数 helper(node, level)，参数是当前节点和节点的层次。程序过程如下：
     *
     * 输出列表称为 levels，当前最高层数就是列表的长度 len(levels)。比较访问节点所在的层次 level 和当前最高层次 len(levels) 的大小，如果前者更大就向 levels 添加一个空列表。
     * 将当前节点插入到对应层的列表 levels[level] 中。
     * 递归非空的孩子节点：helper(node.left / node.right, level + 1)。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-ci-bian-li-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        helper(root, 0);
        return levels;
    }




    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> resList=new ArrayList();
        Queue<TreeNode> queue=new LinkedList();
        if(root==null) {
            return resList;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList();
            int count=queue.size();
            for(int i=0;i<count;i++){
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            resList.add(list);
        }
        return resList;
    }


}