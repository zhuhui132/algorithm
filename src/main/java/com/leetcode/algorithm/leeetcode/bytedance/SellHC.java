package com.leetcode.algorithm.leeetcode.bytedance;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SellHC {
    public int possibleSquareSide;
    public int[] sums;
    public List<Integer> nums;


    public boolean makesquareDFS(int[] nums) {
        if (nums == null || nums.length ==0 ) return false;
        // Find the perimeter of the square (if at all possible)
        int L = nums.length;
        int perimeter = 0;

        for (int i = 0;i<L;i++){
            perimeter +=nums[i];
        }

        this.possibleSquareSide = perimeter/4;

        if (this.possibleSquareSide *4 != perimeter){
            return false;
        }
        this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(this.nums,Collections.reverseOrder() );
        return this.dfs(0);

    }
    // Depth First Search function.
    public boolean dfs(int index) {

        // If we have exhausted all our matchsticks, check if all sides of the square are of equal length
        if (index == this.nums.size()) {
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }

        // Get current matchstick.
        int element = this.nums.get(index);

        // Try adding it to each of the 4 sides (if possible)
        for(int i = 0; i < 4; i++) {
            if (this.sums[i] + element <= this.possibleSquareSide) {
                this.sums[i] += element;
                if (this.dfs(index + 1)) {
                    return true;
                }
                this.sums[i] -= element;
            }
        }

        return false;
    }

}
