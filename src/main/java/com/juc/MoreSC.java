package com.juc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//JDK 升级以后的多生产者/多消费者
public class MoreSC {

    public static void main(String[] args) {

    }


}


class Resource {
    private String name;


    private int count = 1;

    private boolean flag = false;


    //创建一个锁对象


    Lock lock = new ReentrantLock();


    Condition producer_con = lock.newCondition();
    Condition consumer_con = lock.newCondition();


    public void set(String name) {
        lock.lock(); //获取锁
        try {
            while (flag) {
                try {
                    producer_con.wait();
                } catch ( InterruptedException e ) {
                }
            }
            this.name = name + count;
            count++;
            System.out.println(Thread.currentThread().getName() + "..生产者.." + this.name);
            flag = true;
            consumer_con.signal();
        } finally {
            lock.unlock(); //释放锁
        }
    }

    public void out() {
        lock.lock(); //获取锁
        try {
            while (!flag) {
                try {
                    consumer_con.wait();
                } catch ( InterruptedException e ) {
                }
            }
            System.out.println(Thread.currentThread().getName() + "...消费者.." + this.name);
            flag = false;
            producer_con.signal();
        } finally {
            lock.unlock(); //释放锁
        }
    }
}


class Producer implements Runnable {
    Resource r;

    Producer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.set("烤鸭");
        }
    }
}

class Consumer implements Runnable {
    Resource r;

    Consumer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.out();
        }
    }
}


