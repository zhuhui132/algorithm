package com.seven.nio;

import org.apache.ibatis.annotations.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ReactorNIO {

    /**
     * 在Reactor模式中，包含如下角色
     *
     *     Reactor 将I/O事件发派给对应的Handler
     *     Acceptor 处理客户端连接请求
     *     Handlers 执行非阻塞读/写
     */
    public static void main(String[] args)  throws IOException {
        Selector selector = Selector.open();


        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.bind(new InetSocketAddress(2345));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        while (selector.select() > 0){
            Set<SelectionKey> keys = selector.selectedKeys();


            Iterator<SelectionKey> iterator  = keys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()){
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    socketChannel.configureBlocking(false);


                    serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT );

                }
                else if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int count = socketChannel.read(buffer);
                    if (count <= 0) {
                        socketChannel.close();
                        key.cancel();
                        //LOGGER.info("Received invalide data, close the connection");
                        continue;
                    }
                    //LOGGER.info("Received message {}", new String(buffer.array()));
                }
                keys.remove(key);
            }
        }
    }
}