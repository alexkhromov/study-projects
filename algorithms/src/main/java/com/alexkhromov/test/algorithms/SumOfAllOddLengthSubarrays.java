package com.alexkhromov.test.algorithms;

/**
 * Solution for problem https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 */
public class SumOfAllOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {

        int res = 0;

        for (int i = 1; i <= arr.length; i += 2) {
            int end = i;
            for (int j = 1, start = 0; j <= arr.length - i + 1; j++, start = j - 1) {
                while (start < end) {
                    res += arr[start];
                    start++;
                }
                end++;
            }
        }

        return res;
    }
}