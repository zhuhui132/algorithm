package com.middle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Partition {
    public List<List<String>> partition(String s) {
        int len = s.length();

        List<List<String>> res = new ArrayList<>();

        if (len == 0) return res;

        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, stack, res);
        return res;

    }
    /**
     * @param s
     * @param start 起始字符的索引
     * @param len   字符串 s 的长度，可以设置为全局变量
     * @param path  记录从根结点到叶子结点的路径
     * @param res   记录所有的结果
     */
    public void backtracking(String s,int start,int len,Deque<String> path,List<List<String>> res){
        if (start == len){
            res.add(new ArrayList<>(path));
        }


        for (int i =start;i <len;i++){


            // 因为截取字符串是消耗性能的，因此，采用传子串索引的方式判断一个子串是否是回文子串
            // 不是的话，剪枝'

            if(!checkPalindrome(s,start,i)){
                continue;
            }
            path.addLast(s.substring(start,i+1));
            backtracking(s,i+1,len,path,res);
            path.removeLast();


        }
    }

    public boolean checkPalindrome(String str , int left,int right){
        while (left < right){
            if (str.charAt(left) !=str.charAt(right)){
                return  false;
            }
            left++;
            right--;
        }
        return  true;

    }
}