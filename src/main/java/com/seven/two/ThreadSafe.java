package com.seven.two;


//Java如何解决多线程并发问题


import sun.misc.ConditionLock;

import java.io.ObjectInputStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafe {

    /**
     * 常用的保证Java操作原子性的工具是锁和同步方法（或者同步代码块）。
     * 使用锁，可以保证同一时间只有一个线程能拿到锁，
     * 也就保证了同一时间只有一个线程能执行申请锁和释放锁之间的代码。
     */
    public void testLock() {
        Lock lock = new ReentrantLock();


        try {
            lock.lock();
        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void testSynchronized() {
        synchronized (this) {
            //。。。。
        }
    }


//    public void atomicDemo(int numThreads,int iteration ) {
//        AtomicInteger atomicInteger = new AtomicInteger();
//
//
//        for (int b = 0; b < numThreads; b++) {
//            new Thread(() -> {
//
//                for (int a = 0; a < iteration; a++) {
//                    atomicInteger.incrementAndGet();
//                }
//            }).start();
//
//
//        }
//
//    }
}
