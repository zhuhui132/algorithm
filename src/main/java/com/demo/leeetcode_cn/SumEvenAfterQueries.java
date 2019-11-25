package com.demo.leeetcode_cn;


/**
 * A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 *
 * 输出：[8,6,2,4]
 */
public class SumEvenAfterQueries {
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int[][]queries = {{1,0},{-3,1},{-4,0},{2,3}};
        System.out.println(new SumEvenAfterQueries().sumEvenAfterQueries(A, queries));
    }
    int[] result;
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        if (A.length ==0 ||queries.length ==0 ) {return result;}
        int row = queries.length;
        result = new int[row];
        int ret ;
        for (int i =0;i <row;i++){
            int[] temp = A;
            //
            ret = 0;
            temp[queries[i][1]] = A[queries[i][1]]+queries[i][0];
            for(int j = 0;j< temp.length;j++){
                if (temp[j]%2 ==0){
                    ret= ret+temp[j];
                }
            }
            System.out.println(ret);
            result[i] = ret;
        }
        return result;

    }
}