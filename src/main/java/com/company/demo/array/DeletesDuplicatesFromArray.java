package com.company.demo.array;

import java.util.HashSet;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，
 * 使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，
 * 你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class DeletesDuplicatesFromArray {
    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 4, 5, 6, 7, 8};
        System.out.println(removeDuplicates(a));
    }


    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet hs = new HashSet();
        for (int i : nums) {
            hs.add(i);
        }
        return hs.size();
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {return 0;}
        //判断无输入
        int number = 0;//标记计数
        for (int i=0; i < nums.length ; i++) {
            if ( nums[i] != nums[number] ) {
                number++;
                nums[number] = nums[i];
            }
        }
        number+=1; //标记+1即为数字个数
        return number;

    }
}

