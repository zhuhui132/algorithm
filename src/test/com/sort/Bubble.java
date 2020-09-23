package com.sort;

public class Bubble {
    public static void main(String[] args) {

    }

    /**
     * 对冒泡排序常见的改进方法是加入标志性变量 exchange，用于标志某一趟排序过程中是否有数据交换。
     * 如果进行某一趟排序时并没有进行数据交换，则说明所有数据已经有序，可立即结束排序，避免不必要的比较过程。
     * @param arr
     */
    public void bubbleSort(int[] arr){


//        boolean bChange = false; // 交换标志
        int temp = 0;
        for (int i =0;i<arr.length-1;i++){
            // 从后向前依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = arr.length -1;j>i;j--){
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
//                    bChange = true;
                }
            }

            System.out.format("第 %d 趟：\t", i);

//            // 如果标志为false，说明本轮遍历没有交换，已经是有序数列，可以结束排序
//            if (false == bChange)
//                break;

        }
    }
}
