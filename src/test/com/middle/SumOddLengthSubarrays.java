package com.middle;

public class SumOddLengthSubarrays {
//                [1] = 1
//            [4] = 4
//            [2] = 2
//            [5] = 5
//            [3] = 3
//            [1,4,2] = 7
//            [4,2,5] = 11
//            [2,5,3] = 10
//            [1,4,2,5,3] = 15
    //  5  1 3 5
    // 1*3 +4*3 +
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        if (arr.length == 0 )return  0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0;j<arr.length;j++){
                if ((j -i)%2 == 0){
                    // i,j
                    for (int k = i;k<=j ;k++){
                        sum = sum+arr[k];
                    }

                }

            }
        }
        return  sum;
    }

}
