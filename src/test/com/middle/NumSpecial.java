package com.middle;

public class NumSpecial {
    public int numSpecial(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return -1;
        }
/**
 *              [0,0,0,1],
 *              [1,0,0,0],
 *             [0,1,1,0],
 *             [0,0,0,0]
 */
        //行 。列
        int row = mat.length, col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //mat[i][j]
                //得判断是1
                if (mat[i][j] == 1) {
                    //判断该列 该行 还有没有1
                    //mat[i][0]--mat[i][col]
                    //mat[0][j]--mat[row][j]
                }
            }
        }
        return 1;
    }
}