package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {

    }


    public void lock(){


        Lock lock = new ReentrantLock();
        // 新建一个监视器对象
        Condition c1 = lock.newCondition();

        try {
            lock.lock();

        }
        catch (Exception e ){}
        finally {
            lock.unlock();
        }

    }
}
