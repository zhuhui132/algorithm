package com.company.rpc.ali.KryoDemo;

import java.io.*;

public class Main {


    //
//    序列化协议的选择通常有下列一些常用的指标：
//
//    通用性。是否只能用于java间序列化/反序列化，是否跨语言，跨平台。
//    性能。分为空间开销和时间开销。序列化后的数据一般用于存储或网络传输，其大小是很重要的一个参数；
//    解析的时间也影响了序列化协议的选择，如今的系统都在追求极致的性能。
//    可扩展性。系统升级不可避免，某一实体的属性变更，会不会导致反序列化异常，
//    也应该纳入序列化协议的考量范围。
//    易用性。API使用是否复杂，会影响开发效率。
//    容易用的模型通常性能不好，性能好的模型通常用起来都比较麻烦。
//    显然，JDK序列化属于前者。我们不过多介绍它，直接引入今天的主角kryo作为它的替代品。
    public static void main(String[] args) throws Exception {
        Students students = new Students("zhuhui");


        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Students.db"));

        oos.writeObject(students);


        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Students.db"));


        // Students kir
    }
}

class Students implements Serializable{

    private String name;


    public Students(String name){
        this.name = name;
    }

}