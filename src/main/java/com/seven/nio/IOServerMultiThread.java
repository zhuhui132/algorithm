package com.seven.nio;

import com.alibaba.fastjson.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServerMultiThread {

    private static final Logger LOGGER = LoggerFactory.getLogger(IOServerMultiThread.class);
    public static void main(String[] args) {


        ServerSocket serverSocket = null;


        try {
            serverSocket = new ServerSocket();


            serverSocket.bind(new InetSocketAddress(2345));

        }catch ( IOException e ){
            e.printStackTrace();
        }


        try {
            while (true){
                Socket socket = serverSocket.accept();

                new Thread(
                        ()->{
                            try {
                                InputStream inputStream = socket.getInputStream();
                                IOUtils.close(inputStream);
                            }catch ( IOException e ){
                                e.printStackTrace();
                            }
                        }
                ).start();
            }
        }catch ( IOException e ){
            e.printStackTrace();
        }

    }
}
