package com.leetcode.algorithm.utils;

import java.awt.event.ActionListener;
import java.util.*;

public class Lambda {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread run");

            }
        }).start();


        new Thread(()->{
            System.out.print("Hello");
            System.out.println(" Hoolee");
        }).start();

        List<String> list = Arrays.asList("I", "love", "you", "too");
//        list.forEach();
        Collections.sort(list, new Comparator <String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1 == null)
                    return -1;
                if(o2 == null)
                    return 1;
                return o1.length()-o2.length();
            }
        });

        Collections.sort(list,(s1,s2)->{
            if(s1 == null)
                return -1;
            if(s2 == null)
                return 1;
            return s1.length()-s2.length();
        } );

        /**
         * 也许你已经想到了，
         * 能够使用Lambda的依据是必须有相应的函数接口（函数接口，是指内部只有一个抽象方法的接口）。
         * 这一点跟Java是强类型语言吻合，也就是说你并不能在代码的任何地方任性的写Lambda表达式。
         * 实际上Lambda的类型就是对应函数接口的类型。Lambda表达式另一个依据是类型推断机制，
         * 在上下文信息足够的情况下，
         * 编译器可以推断出参数表的类型，而不需要显式指名。Lambda表达更多合法的书写形式如下：
         */

        Runnable run = ()->{
            System.out.println("hello");
        };
        ActionListener listener = e -> {
            System.out.println(" click");
        };


    };
    @FunctionalInterface
    public interface ConsumerInterface<T>{
        abstract void accept(T t);
    };

}
