package com.demo.leeetcode_cn.test_2018;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        //行
        int row = matrix.length;
        //列
        int col = matrix[0].length;
        int posX = 0;
        int posY = col - 1;
        //从右上角往左下角找
        while (posX < row && posY >= 0) {
            if (matrix[posX][posY] == target) {
                return true;
            }
            if (matrix[posX][posY] > target) {
                posY--;
            } else {
                posX++;
            }
        }
        return false;

    }
}
//        for (int i =rowMatrix-1;i>=0;i-- ){
//            for (int j =0;j<= columnMatrix-1;j++){
//                if (matrix[i][j]==target) return true;
//                if (matrix[i][j]>target){
//                    i--;
//                    break;
//                }else{
//                    j++;
//                    break;
//                }
//
//            }
//        }


