package com.easy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JNC extends Wine {
    public static void main(String[] args) {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1, 1,TimeUnit.SECONDS, new ArrayBlockingQueue<new Runnable(){
//            @Override
//            public void run(){
//
//
//            }
//        }() ));
//        Wine wine = new JNC();
//         wine.func1();
    }


    public void func1(String a){
        System.out.println(" JNC func1 ");
        func2();;
    }

    public void func2(){
        System.out.println(" JNC func2 ");
    }
}


class Wine {
    public void func1(){
        System.out.println(" wine func1 ");
        func2();
    }

    public void func2(){
        System.out.println(" wine func2 ");
    }
}