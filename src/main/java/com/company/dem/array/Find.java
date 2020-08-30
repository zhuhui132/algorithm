package com.company.dem.array;

public class Find {
    public boolean Find(int target, int[][] array) {
//        int rows = array.length;//行数
//        int columns = array[0].length;//列数
//
//
//        for (int i =0;i<rows;i++){
//            for (int j = 0;j<columns;i++){
//                if (target<array[i][j]){
//                    return  false;
//                }
//                if (target>array[i][j]){
//
//                }
//            }
//        }


        int row_len = array.length;
        int column_len = array[0].length;


        int row;
        int column;


        for (row = 0, column = column_len - 1; column >= 0 && row < row_len; ) {
            if (target == array[row][column]) {
                return true;
            }
            if (target < array[row][column]) {
                column--;
                continue;
            }
            if (target < array[row][column]) {
                row++;
                continue;
            }
        }
        return false;
    }
}