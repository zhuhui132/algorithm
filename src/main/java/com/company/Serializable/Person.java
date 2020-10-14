package com.company.Serializable;

import java.io.Serializable;

/*
把对象转换为字节序列的过程称为对象的序列化。
　　把字节序列恢复为对象的过程称为对象的反序列化。
　　对象的序列化主要有两种用途：
　　1） 把对象的字节序列永久地保存到硬盘上，通常存放在一个文件中；
　　2） 在网络上传送对象的字节序列。

　　在很多应用中，需要对某些对象进行序列化，
让它们离开内存空间，入住物理硬盘，以便长期保存。
比如最常见的是Web服务器中的Session对象，
当有 10万用户并发访问，
就有可能出现10万个Session对象，
内存可能吃不消，
于是Web容器就会把一些seesion先序列化到硬盘中，
等要用了，再把保存在硬盘中的对象还原到内存中。

　　当两个进程在进行远程通信时，彼此可以发送各种类型的数据。无论是何种类型的数据，都会以二进制序列的形式在网络上传送。发送方需要把这个Java对象转换为字节序列，才能在网络上传送；接收方则需要把字节序列再恢复为Java对象
 */
import java.io.Serializable;

/**
 * <p>ClassName: Person<p>
 * <p>Description:测试对象序列化和反序列化<p>
 * @author xudp
 * @version 1.0 V
 * @createTime 2014-6-9 下午02:33:25
 */
public class Person implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -5809782578272943999L;
    private int age;
    private String name;
    private String sex;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}