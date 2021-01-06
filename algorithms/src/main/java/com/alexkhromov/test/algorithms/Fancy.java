package com.alexkhromov.test.algorithms;

/**
 * Solution for problem https://leetcode.com/problems/fancy-sequence/
 */
public class Fancy {

    private static final int MOD = 1000000007;

    private static final int ARR_SIZE = (int) Math.pow(10, 5);

    private static final int SKIP_OPERATION = -1;

    private final int [] values = new int[ARR_SIZE * 2];
    private final int [] sums = new int[ARR_SIZE];
    private final int [] multipliers = new int[ARR_SIZE];

    private int valueNextIndex = 0;
    private int valueAppendIndex = 0;
    private int operationNextIndex = 0;

    public Fancy() {
    }

    public void append(int val) {
        if (val < 1 || val > 100) return;
        values[valueNextIndex++] = val;
        values[valueNextIndex++] = operationNextIndex;
        valueAppendIndex = operationNextIndex - 1;
    }

    public void addAll(int inc) {

        if (inc < 1 || inc > 100) return;

        if (operationNextIndex - 1 == valueAppendIndex) {
            sums[operationNextIndex] = inc;
            multipliers[operationNextIndex] = SKIP_OPERATION;
        } else {
            if (operationNextIndex > 0 && sums[operationNextIndex - 1] != SKIP_OPERATION) {
                sums[operationNextIndex] = (sums[operationNextIndex - 1] + inc) % MOD;
                sums[operationNextIndex - 1] = SKIP_OPERATION;
            } else {
                sums[operationNextIndex] = inc;
            }
        }

        multipliers[operationNextIndex] = SKIP_OPERATION;
        operationNextIndex++;
    }

    public void multAll(int m) {

        if (m < 1 || m > 100) return;

        if (operationNextIndex - 1 == valueAppendIndex) {
            multipliers[operationNextIndex] = m;
            sums[operationNextIndex] = SKIP_OPERATION;
        } else {
            if (operationNextIndex > 0) {
                if (multipliers[operationNextIndex - 1] != SKIP_OPERATION) {
                    multipliers[operationNextIndex] = moduloMultiplication(multipliers[operationNextIndex - 1], m);
                    multipliers[operationNextIndex - 1] = SKIP_OPERATION;
                } else {
                    multipliers[operationNextIndex] = m;
                }
                if (sums[operationNextIndex - 1] != SKIP_OPERATION) {
                    sums[operationNextIndex] = moduloMultiplication(sums[operationNextIndex - 1], m);
                    sums[operationNextIndex - 1] = SKIP_OPERATION;
                } else {
                    sums[operationNextIndex] = SKIP_OPERATION;
                }
            } else {
                multipliers[operationNextIndex] = m;
                sums[operationNextIndex] = SKIP_OPERATION;
            }
        }

        operationNextIndex++;
    }

    public int getIndex(int idx) {

        if (idx >= ARR_SIZE || idx >= valueNextIndex / 2) return SKIP_OPERATION;

        int result = values[idx * 2];
        for (int i = values[idx * 2 + 1]; i < operationNextIndex; i++) {
            if (sums[i] == SKIP_OPERATION && multipliers[i] == SKIP_OPERATION) continue;
            if (multipliers[i] != SKIP_OPERATION) result = moduloMultiplication(result, multipliers[i]);
            if (sums[i] != SKIP_OPERATION) result = (result + sums[i]) % MOD;
        }
        return result;
    }

    private int moduloMultiplication(int a, int b) {

        int result = 0;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) > 0) {
                result = (result + a) % MOD;
            }
            a = (2 * a) % MOD;
            b >>= 1;
        }

        return result;
    }
}