package com.company.io.Nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioDemo {
    public static void main(String[] args) {

//        1）写入数据到Buffer，一般有可以从Channel读取到到缓冲区中，也可以调用put方法写入。
//
//        2）调用flip()方法，切换数据模式。
//
//        3）从Buffer中读取数据，一般从缓冲区读取数据写入到通道中，也可以调用get方法读取。
//
//        4）调用clear()方法或者compact()方法清空缓冲区。
//
//        当向buffer写入数据时，buffer会记录下写了多少数据。一旦要读取数据，需要通过flip()方法将Buffer从写模式切换到读模式。
//
//        在读模式下，可以读取之前写入到buffer的所有数据。一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。
//
//        有两种方式能清空缓冲区：
//
//        1）clear()方法会清空整个缓冲区。
//
//        2）compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区

    }

    public void bufferReader() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("/NioDemo.java"));

        FileOutputStream fileOutputStream =new FileOutputStream(new File("/zhuhui.java"));


        FileChannel inChannel = fileInputStream.getChannel();


        FileChannel outChannel = fileOutputStream.getChannel();


        ByteBuffer buffer = ByteBuffer.allocate(48);


        while(inChannel.read(buffer)!= -1){
            buffer.flip();

            outChannel.write(buffer);


            buffer.clear();
        }




    }



}
