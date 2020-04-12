package com.algorithm.again;

import java.util.Arrays;
import java.util.List;

public class GetRow {
    public static void main(String[] args) {
        GetRow getRow = new GetRow();
        System.out.println(getRow.getRow(3));
    }
    public List<Integer> getRow(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp,1 );
        for (int i = 2;i<dp.length;i++){
            for (int j = i-1;j>0;j--){
                dp[j] = dp[j]+dp[j-1];
            }
        }
        List<Integer> list = Arrays.asList(dp);
        return list;
    }

}


