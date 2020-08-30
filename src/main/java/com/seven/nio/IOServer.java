package com.seven.nio;

import com.alibaba.fastjson.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 上例使用单线程逐个处理所有请求，同一时间只能处理一个请求，
 * 等待I/O的过程浪费大量CPU资源，同时无法充分使用多CPU的优势。
 */
public class IOServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(IOServer.class);
//使用阻塞I/O的服务器，一般使用循环，逐个接受连接请求并读取数据，然后处理下一个请求。
    public static void main(String[] args) {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(2345));
        }
        catch ( IOException e ){
           e.printStackTrace();
        }



        try {
            while (true){
                Socket socket = serverSocket.accept();

                InputStream inputStream  = socket.getInputStream();
                IOUtils.close(inputStream);

            }
        }catch ( IOException e ){
            e.printStackTrace();
        }

    }
}
