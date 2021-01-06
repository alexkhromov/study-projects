package com.alexkhromov.test.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sum1DArrayTest {

    private Sum1DArray sum1DArray = new Sum1DArray();

    @Test
    public void test_1() {

        assertEquals("[1, 3, 6, 10]", Arrays.toString(
                sum1DArray.runningSum(new int[]{1, 2, 3, 4})));
    }

    @Test
    public void test_2() {

        assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(
                sum1DArray.runningSum(new int[]{1, 1, 1, 1, 1})));
    }

    @Test
    public void test_3() {

        assertEquals("[3, 4, 6, 16, 17]", Arrays.toString(
                sum1DArray.runningSum(new int[]{3, 1, 2, 10, 1})));
    }
}