package com.alexkhromov.test.algorithms;

import java.util.Arrays;

/**
 * Solution for problem https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public static void main(String[] args) {

        TwoSum test = new TwoSum();

        //System.out.println(Arrays.toString(test.twoSum(new int []{2, 7, 11, 15}, 9)));
        //System.out.println(Arrays.toString(test.twoSum(new int []{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(test.twoSum(new int []{3, 3}, 6)));
    }

    public int [] twoSum(int [] nums, int target) {

        int [] indices = new int [2];

        outer:
        for (int i = 0; i < nums.length; i++) {

            indices[0] = i;

            for (int j = 0; j < nums.length; j++) {

                if (j == i) continue;

                if (nums[indices[0]] + nums[j] == target) {

                    indices[1] = j;
                    break outer;
                }
            }
        }

        return indices;
    }
}