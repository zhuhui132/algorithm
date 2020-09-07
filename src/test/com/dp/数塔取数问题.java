package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//取最大
public class 数塔取数问题 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        long max= 0 ;
        int[][] dp = new int[n][n];
        dp[0][0] = in.nextInt();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int num = in.nextInt();
                if (j == 0)
                    dp[i][j] = dp[i - 1][j] + num;
                else
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num;
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);


        数塔取数问题 test = new 数塔取数问题();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(8,4));
        list.add(Arrays.asList(3,6,9));
        list.add(Arrays.asList(7,2,9,5));
        /**
         * 1
         * 9 13
         * 12 18 27
         * 22 24 36
         */
       // list.add(Arrays.asList(1));

        test.maxTotal(list);

    }



    public int maxTotal(List<List<Integer>> triangle) {
        //几行
        int n = triangle.size();
        //创建存值得二维数组
        int[][] f =new int[n][n];
        //赋值00
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1;i<n;i++){
            f[i][0] = f[i-1][0]+triangle.get(i).get(0);
            for (int j = 1;j<i;j++){
                f[i][j] = Math.max(f[i-1][j-1],f[i-1][j])+triangle.get(i).get(j);

            }
            f[i][i] = f[i-1][i-1] +triangle.get(i).get(i);
        }

        int maxTotal = f[n-1][0];
        for (int i =1;i<n ;i++){
            maxTotal = Math.max(maxTotal,f[n-1][i]);
        }
        System.out.println(maxTotal);
        return maxTotal;


    }
}
