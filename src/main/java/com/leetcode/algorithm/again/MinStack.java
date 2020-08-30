package com.leetcode.algorithm.again;

import java.util.Stack;

public class MinStack {
    public Stack<Integer> stackOne = new Stack <>();
    public Stack<Integer> stacktwo = new Stack <>();


    public void push(int node) {
        stackOne.push(node);
    }

    public void pop() throws Throwable {
        if (stackOne.size()==0){
            throw new Throwable("栈为空");
        }else {
            stackOne.pop();
        }
    }

    public int top() {
        return stackOne.peek();
    }

    public int min() {
        int min = stackOne.peek();
        while (stackOne.size() != 0){
            min = min>stackOne.peek()?stackOne.peek():min;
            stacktwo.push(stackOne.pop());
        }
        while (stacktwo.size() != 0){

            stackOne.push(stacktwo.pop());
        }
        return min;

    }

}
