package com.company.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    private AtomicInteger i ;


    private volatile int j;

    public static void main(String[] args) {

    }


    public void add(){
        i.getAndDecrement();

    }


    public synchronized void addJ(){
        j++;
    }



//    public final int getAndAddInt (Object var1, long var2, int var4) {
//        int var5;
//        do {
//            var5 = this.getIntVolatile(var1, var2);
//        } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
//
//
//    }
}
