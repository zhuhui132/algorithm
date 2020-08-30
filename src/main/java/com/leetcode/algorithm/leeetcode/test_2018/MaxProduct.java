package com.leetcode.algorithm.leeetcode.test_2018;

public class MaxProduct {
    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        maxProduct.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"});
    }

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    public boolean noCommonLetters(String s1, String s2) {
        Boolean reslut = true;
        char[] chars = s1.toCharArray();
        for (char i : chars) {
            if (s2.indexOf(String.valueOf(i)) != -1) {
                reslut = false;
                break;
            }
        }
        return reslut;
    }


    public int maxProduct(String[] words) {
        int n = words.length;

        int maxProd = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (noCommonLetters(words[i], words[j]))
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
            }
        }
        System.out.println(maxProd);
        return maxProd;
    }
}