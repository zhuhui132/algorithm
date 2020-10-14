package com.company.demo.sort;

public class BubbleSort {
    public static void main(String[] args) {

    }
    public void bubbleSort(int []a){
        int len = a.length;
        for (int i = 0;i<len;i++){
            for (int j = 0;j<len-i-1;j++){
                if (a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
