package com.leetcode.algorithm.leeetcode.june;

public class IslandPerimeter {
    public static void main(String[] args) {
        for (int i = 0; i <= 3 ; i++) {
            for (int j=3 ;j>=0;j--){
                System.out.println(i);
                System.out.println(j);
                if (j ==i ){
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }
            }
        }
    }
//    public int islandPerimeter(int[][] grid) {
//
//        //行
//        int row = grid.length;
//        int colown = grid[0].length;
//
//
//        int res = 0;
//        for (int i =0,j =0;i <row && j<colown;i++,j++){
//            grid[i][j]
//        }
//    }

}
