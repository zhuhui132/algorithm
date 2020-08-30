package com.juc;

public class AtomicDemo {

    public static void main(String[] args) {

        Atomic ad = new Atomic();

        for(int i=0; i < 10; i++){
            new Thread( ad).start();
        }
    }
}


class Atomic implements Runnable{
    private int serialNumber = 0;


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */

    @Override
    public void run() {
        try{
            Thread.sleep(200);
        }catch(InterruptedException e){

        }

        System.out.println(Thread.currentThread().getName()+":" + getSerialNumber());
    }
    public int getSerialNumber(){
        return serialNumber++;
    }
}
