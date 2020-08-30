package com.company.dem;

public class Find{
    public boolean find(int target,int[][] array){

        int row_len = array.length;
        int column_len  = array[0].length;

        int row ;
        int column;


        for (row = 0,column = column_len -1; column>=0&&row <row_len; ) {
            if (array[row][column] == target) {
                return true;
            }

            if (target <array[row][column]) {
                column --;
                continue;
            }
            if (target >array[row][column]) {
                row++;
                continue;
            }

        }
         return false;


    }
}
