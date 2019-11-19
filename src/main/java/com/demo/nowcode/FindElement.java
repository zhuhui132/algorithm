package com.demo.nowcode;

public class FindElement {
    public static void main(String[] args) {

    }
    public boolean find(int target,int[][] array){
        int rows = array.length;
        int cols = array[0].length;

        int i = rows-1,j=0;
        while (i>=0 && j<cols){
            if(target < array[i][j]){
                i--;
            }
            else if (target > array[i][j]){
                j++;
            }
            else{ return true;}
        }
        return  false;
    }
}
