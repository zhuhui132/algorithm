package com.leetcode.algorithm.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Yanghuisanjiao {
    public static void main(String[] args) {
        Yanghuisanjiao yanghuisanjiao = new Yanghuisanjiao();
        yanghuisanjiao.generate(3);
    }

    public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> lists = new ArrayList <>();

    List<Integer> row = new ArrayList <>();
    for (int i =0;i<numRows;i++){
        row.add(0,1);
        for (int j =i;j<row.size()-1;j++){
            row.set(j,row.get(j)+row.get(j-1) );
        }
        lists.add(row);
    }
    return lists;

    }

    public List<List<Integer>> generate2(int numRows) {

        List<List<Integer>> triangle = new ArrayList <>();
        if (numRows == 0)return triangle;

        triangle.add(new ArrayList <>());
        triangle.get(0).add(1);

        for (int rowNum = 1;rowNum<numRows;rowNum++){
            List<Integer> row = new ArrayList <>();
            List<Integer> preRow = triangle.get(rowNum-1);
            row.add(1);
            for (int j =1;j<rowNum;j++){
                row.add(preRow.get(j-1)+preRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;


    }

    public List<Integer> getRow(int rowIndex) {
        Integer[] dp = new Integer[rowIndex+1];
        Arrays.fill(dp,1 );
        for (int i =2;i<dp.length;i++){
            for (int j =i-1;j>0;j--){
                dp[j] = dp[j]+dp[j-1];
            }
        }

       List<Integer> list = Arrays.asList(dp);
        return list;

    }
}
