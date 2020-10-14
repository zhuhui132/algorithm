package com.leetcode.algorithm.again;

import java.util.Stack;

public class UseStack {
    public static void main(String[] args) {

    }


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }


    public int pop() {
        while (stack1.size() != 0){
            stack2.push(stack1.pop());
        }

        int result = stack2.pop();
        while (stack2.size() != 0){
            stack1.push(stack2.pop());
        }
        return result;
    }

}