package com.algorithm.leeetcode_cn.usually;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 */
class Solution {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
   //     shiftGrid(grid,1 );
        System.out.println(shiftGrid(grid,4 ));
    }
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList <>();
        //行
        int rows = grid.length;

        //列·
        int cols = grid[0].length;
        while(k != 0){

            int[] tmep = new int[rows];
            for (int i =0;i<rows;i++){
                tmep[i] = grid[i][cols-1];
                System.out.println("tmep[i]"+tmep[i]);
            };
            //每列

             for (int i =0;i<rows;i++){
                 //每行右移动一
                 for (int j= cols-1;j>0;j--){
                     grid[i][j]= grid[i][j-1];
                     System.out.println("i="+i+"j="+j+"=========="+grid[i][j]);
                 }
             }
            /**
             * grid[0][2] = grid[0][1]
             * grid[0][1] = grid[0][0]
             *
             * grid[1][2] = grid[1][1]
             * grid[1][1] = grid[1][0]
             */
            
            int tmpInt = tmep[tmep.length-1];

            for (int i = tmep.length-1 ;i>=1;i--){
                //tmep[2] = tmep[1]
                //tmep[1] = temp[0];

                tmep[i] = tmep[i-1];
            }
            tmep[0] = tmpInt;


            for (int i =0;i<rows;i++){
                grid[i][0] = tmep[i];
                System.out.println(grid[i][0]);
            }
            k--;


        }
        for(int i = 0;i<rows ;i++){
            List<Integer> list = new ArrayList <>();
            for (int j= 0;j<cols ;j++){
                list.add(grid[i][j]);
            }
            for (int var: list
            ) {
                System.out.print(var);

            }
            result.add(list);
        }

        return result;
    }
}