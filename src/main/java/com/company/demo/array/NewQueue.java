package com.company.demo.array;

import java.util.Stack;

public class NewQueue{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public void push(int node){
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        stack1.push(node);

   stack1.push(node);
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    public void pop(){
     stack2.pop();
    }
}
