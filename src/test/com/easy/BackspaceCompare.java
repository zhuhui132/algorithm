package com.easy;

import java.util.Stack;

public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (Character c: S.toCharArray()) {
            if (c=='#'){
                if (stack1.size() != 0){
                    stack1.pop();
                }
            }else {
                stack1.push(c);
            }
        };

        for (Character c: T.toCharArray()) {
            if (c=='#'){
                if (stack2.size() != 0){
                    stack2.pop();
                }
            }else {
            stack2.push(c);
            }
        };

        if (stack1.toString() .equals( stack2.toString())){
            return true;
        }
        return false;

    }
}