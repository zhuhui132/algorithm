package com.juc;

//
//volatile 关键字: 当多个线程进行操作共享数据时,可以保证内存中的数据是可见的;
//相较于 synchronized 是一种 较为轻量级的同步策略;
//volatile 不具备"互斥性";
//volatile 不能保证变量的"原子性";
public class TestVoliate {

    public static void main(String[] args) {


        ThreadDemo td = new ThreadDemo();

        new Thread(td).start();

        while(true){
            if(td.isFlag()){
                System.out.println("########");
                break;
            }
        }




//        while (true){
//            synchronized (td){
//                if(td.isFlag()){
//                    System.out.println("########");
//                    break;
//                }
//            }
//        }
    }
}


class ThreadDemo implements Runnable{
    //private volatile boolean flag = false;


    private boolean flag = false;


    //https://www.cnblogs.com/xiaoxi/p/6896912.html
    // wait and sleep compare


    @Override
    public void run() {

        try {
            // 该线程 sleep(200), 导致了程序无法执行成功
            Thread.sleep(200);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        flag = true;

        System.out.println("flag="+isFlag());

    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


}

