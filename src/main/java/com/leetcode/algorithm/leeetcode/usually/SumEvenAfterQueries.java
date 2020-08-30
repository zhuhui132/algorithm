package com.leetcode.algorithm.leeetcode.usually;


import java.util.ArrayList;
import java.util.List;

/**
 * A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 * <p>
 * 输出：[8,6,2,4]
 */
public class SumEvenAfterQueries {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        //System.out.println(new SumEvenAfterQueries().sumEvenAfterQueries(A, queries));

        String s = "abbxxxxzzy";
        System.out.println(new SumEvenAfterQueries().largeGroupPositions(s));
    }

    int[] result;

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        if (A.length == 0 || queries.length == 0) {
            return result;
        }
        int row = queries.length;
        result = new int[row];
        int ret;
        for (int i = 0; i < row; i++) {
            int[] temp = A;
            //
            ret = 0;
            temp[queries[i][1]] = A[queries[i][1]] + queries[i][0];
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] % 2 == 0) {
                    ret = ret + temp[j];
                }
            }
            System.out.println(ret);
            result[i] = ret;
        }
        return result;

    }


    public List <List <Integer>> largeGroupPositions(String S) {
        List <List <Integer>> result = new ArrayList <>();


        char[] chars = S.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {

                if (chars[i] == chars[j]) {
                    while (j - i > 2) {
                        List <Integer> lists = new ArrayList <>();
                        lists.add(i);
                        lists.add(j);
                        result.add(lists);
                        break;
                    }
                }else {
                    break;
                }
                //  else break;


            }
        }


        return result;
    }



//
//    public List <List <Integer>> largeGroupPositions2(String S) {
//        List <List <Integer>> result = new ArrayList <>();
//
//
//        char[] chars = S.toCharArray();
//
//        int i =0,r = 0,count = 0;
//
//        while (r <chars.length){
//            if (chars[r] == chars[1]){
//                r++;
//                count++;
//            }
//            else if (count>)
//
//
//        }
//        return result;
//    }
}
