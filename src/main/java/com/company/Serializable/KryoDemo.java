package com.company.Serializable;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;

public class KryoDemo {
    public static void main(String[] args)  throws  Exception{


        Kryo kryo = new Kryo();


        Output out = new Output(new FileOutputStream("zhuhui.java"));


        Student kirito = new Student("kirito");

        kryo.writeObject(out,kirito );


        out.close();

        Input input = new Input(new FileInputStream("student.dn"));
        Student kiritoInput = kryo.readObject(input,Student.class );


        input.close();

        //assert "kirito".equals(kiritoInput.getName());



    }
}



class Student implements Serializable{

    private String name;

    public Student(String name){
        this.name = name;
    }
}
