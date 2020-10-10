package com.zhuhui.guava.utilites;

public class Test {
    // 2 100
    public   volatile int inc = 0;


    public void increase() {
        inc++;
    }


    public static void main(String[] args) {
        final Test test = new Test();

        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                }
            }.start();
        }

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }

//
//    public int tets(int egg,int stari){
//        int sum = 0 ;
//
//
//        //假如 第一个鸡蛋 第一层
//        for (int i =0;i<egg;i++){
//            //比较
//        }
//    }
}
//1 2 4 8 16
// 2*2*2*2*2*2*2*2=64
//