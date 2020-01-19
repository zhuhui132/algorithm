package com.algorithm.nowcode;

public class FindElement {
    public static void main(String[] args) {

    }

    /**
     * 2   5  9
     * 13  18 19
     * 14  20 21
     *
     * @param target
     * @param array
     * @return
     */
    public boolean find(int target, int[][] array) {
        //行数
        int rows = array.length;
        //列数
        int cols = array[0].length;

        int i = rows - 1, j = 0;
        while (i >= 0 && j < cols) {
            if (target < array[i][j]) {
                i--;
            } else if (target > array[i][j]) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
