package com.middle;

import java.util.ArrayList;
import java.util.List;

public class GetRow {
    public static void main(String[] args) {

    }

    // 杨辉三角
    // 1
    //  1 1
    // 1 2  (list.get(i-1).get(j-1)+list.get(i-1).get(j))   1
    public List<Integer> getRow(int N) {

        List<Integer> res = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            res.add(1);
            for (int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }



    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> sub = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i) {
                    sub.add(1);

                } else {
                    sub.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }

        }
        return result;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        if (numRows == 0) {
            return pascal;
        }
        pascal.add(new ArrayList<>());
        pascal.get(0).add(1);
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = pascal.get(rowNum - 1);

            row.add(1);


            for (int j = 1; j < rowNum; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }
            row.add(1);

            pascal.add(row);

        }
        return pascal;

    }
//        List<List<Integer>> pascal = new ArrayList<>();
//        ArrayList<Integer> row = new ArrayList<>();
//
//
//        for (int i = 0;i<numRows;i++){
//            row.add(1); //（0，1）中的0是索引，1是值。 每一组首先添加1进行运算
//            for (int j = 1;j<row.size()-1;j++){
//                row.set(j,row.get(j)+row.get(j+1));
//                pascal.add(new ArrayList<>(row));
//
//            }
//        }
//        return pascal;
//    }
}
