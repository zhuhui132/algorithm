package com.algorithm.nowcode;

import java.util.ArrayList;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ls = new ArrayList<Integer>();
        int colStart = 0;
        int colEnd = matrix[0].length;

        int lineStart = 0;
        int lineEnd = matrix.length;
        int count = lineEnd * colEnd;
        if (matrix == null)
            return ls;
        while (count != 0) {
            for(int i = colStart;i<colEnd;i++){
                ls.add(matrix[lineStart][i]);
                count--;
            }
            lineStart++;
            if(count==0)
                break;
            for(int i = lineStart;i<lineEnd;i++){
                ls.add(matrix[i][colEnd-1]);
                count--;
            }
            colEnd--;
            if(count==0)
                break;
            for(int i = colEnd-1;i>=colStart;i--){
                ls.add(matrix[lineEnd-1][i]);
                count--;
            }
            lineEnd--;
            if(count==0)
                break;
            for(int i = lineEnd-1;i>=lineStart;i--){
                ls.add(matrix[i][colStart]);
                count--;
            }
            colStart++;
            if(count==0)
                break;
        }
        return ls;
    }
}