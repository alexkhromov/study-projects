package com.alexkhromov.test.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShuffleStringTest {

    private ShuffleString shuffleString = new ShuffleString();

    @Test
    public void test_1() {

        assertEquals("leetcode",
                shuffleString.restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }

    @Test
    public void test_2() {

        assertEquals("abc",
                shuffleString.restoreString("abc", new int[]{0, 1, 2}));
    }

    @Test
    public void test_3() {

        assertEquals("nihao",
                shuffleString.restoreString("aiohn", new int[]{3, 1, 4, 2, 0}));
    }

    @Test
    public void test_4() {

        assertEquals("arigatou",
                shuffleString.restoreString("aaiougrt", new int[]{4, 0, 2, 6, 7, 3, 1, 5}));
    }

    @Test
    public void test_5() {

        assertEquals("rat",
                shuffleString.restoreString("art", new int[]{1, 0, 2}));
    }
}
