package com.algorithm.again;

public class ReOrderArray {
    public void reOrderArray(int[] array) {
        int[] result = new int[array.length];
        int j = 0;
        int o = array.length - 1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                result[j++] = array[i];
            }
            if (array[array.length - i - 1] % 2 == 0) {
                result[o--] = array[array.length - i - 1];
            }
        }
        for (int i = 0; i < result.length; i++) {
            array[i] = result[i];
        }
    }
}