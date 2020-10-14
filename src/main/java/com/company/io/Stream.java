package com.company.io;

import java.io.*;

//InputStream和OutputStream为字节流设计，
// Reader和Writer为字符流设计，
// 字节流和字符流形成分离的层次结构。
// 一般来说，处理字符或字符串使用字符流类，
// 处理字节或二进制对象使用字节流。
public class Stream {
    /**
     *操作文件流时，不管是字符流还是字节流，都可以按照以下方式进行：
     *
     * 1、使用File类找到一个对象
     *
     * 2、通过File类的对象去实例化字节流或字符流的子类
     *
     * 3、进行字节（字符）的读、写操作
     *
     * 4、关闭文件流
     **/

    public static void main(String[] args) throws IOException {
        File file = new File("D:/Files/stream.txt");
        //FileOutputStream（文件字节输出流）
        OutputStream out = new FileOutputStream(file);

        byte[] b = "Hello ,world".getBytes();

        out.write(b);
        out.close();


    }
}
