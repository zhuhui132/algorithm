package com.easy;

import java.util.concurrent.*;

public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0;i<15;i++){
            MyTask task = new MyTask(i);

            executor.execute(task);

            executorService.submit(task);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());


        }
        executor.shutdown();
    }
}


class MyTask implements Runnable {
    private int taskNum;
    public MyTask(int num){
        this.taskNum  = num;
    }

    @Override
    public void run(){

        System.out.println("正在执行task "+taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}