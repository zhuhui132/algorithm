package com.zhuhui.guava.utilites;

public class ThreadTest  implements Runnable {
    private int i = 1;

    @Override
    public void run() {
        System.out.println("Hellp");
        System.out.println(i);
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        ThreadTest threadTest1 = new ThreadTest();
        Thread thread  = new Thread(threadTest);
        threadTest.i++;
        thread.start();

        Thread thread2  = new Thread(threadTest1);
        thread2.start();

    }
}
//hasmap
//16 8 // honghwihu
//violatte sys
//t4//