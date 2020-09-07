package com.easy;



public class RelativeSortArray {
    public static void main(String[] args) {
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        relativeSortArray.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},new int[]{2,1,4,3,9,6});
    }

    /**
     * arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 1  2 2 2  3 3  4  6 7 9 19
     * 1   3     2    1  0 0 1 0
     * 2 1 4 3 9 6
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int num1:arr1){
            count[num1] ++;

        }
        int i =0;
        for (int num2:arr2){
            while (count[num2] > 0 ){
                arr1[i++] = num2;
                count[num2]--;

            }
        }

        // 再排剩下的数
        for (int num1 = 0; num1 < count.length; num1++) {
            while (count[num1] > 0) {
                arr1[i++] = num1;
                count[num1]--;
            }
        }
        return arr1;
    }

//        for (int i:arr2){
//            for (int j = 0;j< arr1.length;j++){
//                if (i ==arr1[j]){
//                    if (map.get(i) == null){
//                        map.put(i,1);
//                    }
//                    else map.put()
//                }
//            }
//        }
//    }
}