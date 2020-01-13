package com.demo.dp;

public class Array {
    private int[] data;
    private int size;

    //无参构造
    public Array(){
        this(10);
    }

    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    public int getData() {
        return data.length;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void addLast(int key){
        if (size == data.length) {
            throw  new IllegalArgumentException(" fail ");
        }
        data[size] = key;
        size++;

    }
    public void addLast(int key,int value){
        // key  和 size
        if (key >= data.length || key < 0  || size == data.length ) {
            throw  new IllegalArgumentException(" fail ");
        }


        for (int i = key;i<data.length;i++){
            data[i+1] = data[i];
        }

        data[key] = key;
        size++;

    }

}
