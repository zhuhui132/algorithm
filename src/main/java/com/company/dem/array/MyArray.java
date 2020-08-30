package com.company.dem.array;

import java.util.Arrays;

public class MyArray {
    private int[] elements;

    public MyArray() {
        elements = new int[0];
    }


    public int size() {
        return elements.length;
    }
//放在尾部
    public void add(int element) {
        int[] newArr = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = element;
        elements = newArr;
    }

    public void show(){
        System.out.println(Arrays.toString(elements));
    }


    public void delete(int index) throws Exception {
        if (index<0 || index>elements.length){
            throw new Exception("异常");
        }

        int[] newArr = new int[elements.length-1];
        for (int i = 0;i<newArr.length;i++) {
            if (i<index){
                newArr[i] = elements[i];
            }else {
                newArr[i] = elements[i-1];
            }
            elements = newArr;
        }
    }


    public void insert(int index ,int element) throws Exception {
        if (index<0||index>elements.length){
            throw new Exception("");
        }

        int[] newArr = new int[elements.length+1];

        for (int i = 0;i<elements.length;i++){
            if (i<index){

            }
            else if (i==index){

            }
            else {


            }
        }



    }
}
