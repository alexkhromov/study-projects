package com.alexkhromov.test.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfAllOddLengthSubarraysTest {

    private SumOfAllOddLengthSubarrays sumOfAllOddLengthSubarrays = new SumOfAllOddLengthSubarrays();

    @Test
    public void test_1() {

        assertEquals(58,
                sumOfAllOddLengthSubarrays.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
    }

    @Test
    public void test_2() {

        assertEquals(3,
                sumOfAllOddLengthSubarrays.sumOddLengthSubarrays(new int[]{1, 2}));
    }

    @Test
    public void test_3() {

        assertEquals(66,
                sumOfAllOddLengthSubarrays.sumOddLengthSubarrays(new int[]{10, 11, 12}));
    }

    @Test
    public void test_4() {

        assertEquals(878,
                sumOfAllOddLengthSubarrays.sumOddLengthSubarrays(
                        new int[]{6, 9, 14, 5, 3, 8, 7, 12, 13, 1}));
    }
}