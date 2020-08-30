package com.company.io;

import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class IODemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        //ExecutorService executorService = new ThreadPoolExecutor();

//        ServerSocket serverSocket = new ServerSocket();
//        serverSocket.bind();
//        while(!Thread.currentThread.isInturrupted()){//主线程死循环等待新连接到来
//            Socket socket = serverSocket.accept();
//            executor.submit(new ConnectIOnHandler(socket));//为新的连接创建新的线程
//

    }




}

class ConnectIOOnHandler extends Thread{
    private Socket socket;
    public ConnectIOOnHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run()  {
        while (!Thread.currentThread().isInterrupted() && !socket.isClosed()){
            String someThing = null;
            try {
                someThing = socket.getInputStream().toString();
            } catch ( IOException e ) {
                e.printStackTrace();
            }
            if(someThing!=null){
            // ......//处理数据
                try {
                    socket.getOutputStream().write(someThing.getBytes());
                } catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
        }
    }
}
