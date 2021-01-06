package com.alexkhromov.test.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShuffleArrayTest {

    private ShuffleArray shuffleArray = new ShuffleArray();

    @Test
    public void test_1() {

        assertEquals("[2, 3, 5, 4, 1, 7]", Arrays.toString(
                shuffleArray.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }

    @Test
    public void test_2() {

        assertEquals("[1, 4, 2, 3, 3, 2, 4, 1]", Arrays.toString(
                shuffleArray.shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)));
    }

    @Test
    public void test_3() {

        assertEquals("[1, 2, 1, 2]", Arrays.toString(
                shuffleArray.shuffle(new int[]{1, 1, 2, 2}, 2)));
    }
}
