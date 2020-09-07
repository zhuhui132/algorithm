package com.dp;

import java.util.List;

//三角形最小路径和
public class MinimumTotal {
    /**
     * [2]
     * [3,4]
     * [6,5,7]
     * [4,1,8,3]
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        //几行
        int n = triangle.size();
        //创建存值得二维数组
        int[][] f =new int[n][n];
        //赋值00
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1;i<n;i++){
            f[i][0] = f[i-1][0]+triangle.get(i).get(0);
            for (int j = 1;j<i;j++){
                f[i][j] = Math.min(f[i-1][j-1],f[i-1][j])+triangle.get(i).get(j);

            }
            f[i][i] = f[i-1][i-1] +triangle.get(i).get(i);
        }

        int minTotal = f[n-1][0];
        for (int i =1;i<n ;i++){
            minTotal = Math.min(minTotal,f[n-1][i]);
        }
        return minTotal;


    }
}
