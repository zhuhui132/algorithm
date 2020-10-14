package com.leetcode.algorithm.again;

public class Find {
    public static void main(String[] args) {
        int[][] demo = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Find find = new Find();
        find.find(7,demo );
    }
    //123
    //456
    //789
    public boolean find(int target, int[][] array) {
        int rows = array.length;
        int colomus = array[0].length;


        int row = rows - 1;
        int colomu = 0;
        while (row >= 0 && colomu < colomus) {
             if (target >array[row][colomu]){
                 colomu++;
            }
            else if (target<array[row][colomu]){
                 row--;
            }
            else {
                return true;
            }

        }
        return false;
    }
}
