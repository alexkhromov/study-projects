package com.alexkhromov.test.algorithms;

/**
 * Solution for problem https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class Sum1DArray {

    public int[] runningSum(int[] nums) {

        int inc = 0;
        for (int i = 0; i < nums.length; i++) {

            int temp = nums[i];
            if (i != 0) {
                nums[i] += inc;
            }
            inc += temp;
        }

        return nums;
    }
}