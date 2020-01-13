package com.demo.leeetcode_cn.test_2018;

public class IncreasingTriplet {
    public static void main(String[] args) {
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        int[] test = new int[]{2,1,5,0,4,6};

        increasingTriplet.increasingTriplet2(test);
    }
    public boolean increasingTriplet(int[] nums) {
        boolean result = false;
        if (nums.length < 3) {
            return result;
        }

        int i = 1;

        while (i <= nums.length - 2) {
            if (nums[i] < nums[i + 1] && nums[i] > nums[i - 1]) {
                result = true;
            }
            if (result == true) {
                break;
            }
            i++;
        }
        return result;
    }

    public boolean increasingTriplet2(int[] nums) {
        boolean result = false;
        if (nums.length < 3) {
            return result;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            if (nums[low] >= nums[high]) {
                low++;
            } else {
                for (int i = low+1; i <=high-1; i++) {
                    while (nums[i] > nums[low] && nums[i] < nums[high]) {
                        result = true;
                        break;
                    }

                }
                break;
            }
        }
        return result;
    }



    public boolean increasingTriplet3(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for (int e : nums) {
            if (e <= a) {
                a = e;
            } else if (e <= b) {
                b = e;
            } else {
                return true;
            }
        }
        return false;
    }
}