package com.alexkhromov.test.algorithms;

/**
 * Solution for problem https://leetcode.com/problems/shuffle-the-array/
 */
public class ShuffleArray {

    public int[] shuffle(int[] nums, int n) {

        int [] result = new int[nums.length];

        for (int i = 0; i < n; i++) {

            result[i * 2] = nums[i];
            result[i * 2 + 1] = nums[i + n];
        }

        return result;
    }
}