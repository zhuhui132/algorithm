package com.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    /***
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return new  int[0];
        }

        int[] res = new int[nums.length-k+1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i=0,j=0;i<nums.length;i++){
            if (!queue.isEmpty() && i-queue.peek() >= k){
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i]>nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k -1){
                res[j++] = nums[queue.peek()];
            }
        }

        return res;

    }
}