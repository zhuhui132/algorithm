package com.seven.three;


import java.util.Date;

/**
 * sleep和wait到底什么区别
 *
 * 其实这个问题应该这么问——sleep和wait有什么相同点。
 * 因为这两个方法除了都能让当前线程暂停执行完，几乎没有其它相同点。
 *
 * wait方法是Object类的方法，这意味着所有的Java类都可以调用该方法。
 * sleep方法是Thread类的静态方法。
 *
 * wait是在当前线程持有wait对象锁的情况下，暂时放弃锁，
 * 并让出CPU资源，并积极等待其它线程调用同一对象的notify或者notifyAll方法。
 * 注意，即使只有一个线程在等待，并且有其它线程调用了notify或者notifyAll方法，
 * 等待的线程只是被激活，但是它必须得再次获得锁才能继续往下执行。换言之，即使notify被调用，
 * 但只要锁没有被释放，原等待线程因为未获得锁仍然无法继续执行。测试代码如下所示
 *
 *
 */
public class Wait {


    /**
     * http://www.jasongj.com/java/multi_thread/
     */
    public static void main(String[] args) {


        Thread thread1 = new Thread(
                ()->{
                    synchronized (Wait.class){
                        try {
                            System.out.println(new Date() + " Thread1 is running");
                            Wait.class.wait();
                            System.out.println(new Date() + " Thread1 ended");
                        }
                        catch ( Exception e ){
                            e.printStackTrace();
                        }
                    }
                }
        );
        thread1.start();




        Thread thread2 = new Thread(() -> {
            synchronized (Wait.class) {
                try {
                    System.out.println(new Date() + " Thread2 is running");
                    Wait.class.notify();
                    // Don't use sleep method to avoid confusing
                    for(long i = 0; i < 200000; i++) {
                        for(long j = 0; j < 100000; j++) {}
                    }
                    System.out.println(new Date() + " Thread2 release lock");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            for(long i = 0; i < 200000; i++) {
                for(long j = 0; j < 100000; j++) {}
            }
            System.out.println(new Date() + " Thread2 ended");
        });

        // Don't use sleep method to avoid confusing
        for(long i = 0; i < 200000; i++) {
            for(long j = 0; j < 100000; j++) {}
        }
        thread2.start();
    }
}