package com.company.dem.sort;

public class InsertSort {
    public static void main(String[] args) {

    }
    public void insertSort(int[] a){
        int len = a.length;

        int insertNum;

        for (int i = 0;i<len;i++){
            insertNum = a[i];
            int j=i-1;//序列元素个数
            while (j>=0 && a[j]>insertNum){
                a[j+1] = a[j];
                j--;
            }
            a[j+1]=insertNum;//找到位置，插入当前元素
        }
    }
}
