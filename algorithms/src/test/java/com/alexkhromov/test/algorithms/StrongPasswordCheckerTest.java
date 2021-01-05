package com.alexkhromov.test.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrongPasswordCheckerTest {

    private StrongPasswordChecker test = new StrongPasswordChecker();

    @Test
    public void strongPasswordCheckerTest() {

        assertEquals(5, test.strongPasswordChecker("a"));
        assertEquals(3, test.strongPasswordChecker("aA1"));
        assertEquals(3, test.strongPasswordChecker("..."));
        assertEquals(3, test.strongPasswordChecker("!!!"));
        assertEquals(3, test.strongPasswordChecker("aaa"));
        assertEquals(2, test.strongPasswordChecker("kkkk"));
        assertEquals(1, test.strongPasswordChecker("000aA"));
        assertEquals(2, test.strongPasswordChecker("QQQQQ"));

        assertEquals(2, test.strongPasswordChecker("aaa111"));
        assertEquals(2, test.strongPasswordChecker("aaaaaa"));

        assertEquals(0, test.strongPasswordChecker("1337C0d3"));
        assertEquals(3, test.strongPasswordChecker("1111111111"));

        assertEquals(7, test.strongPasswordChecker("kkkkkkkkkkkkkkkkkkkkk"));
        assertEquals(7, test.strongPasswordChecker("..................!!!"));
        assertEquals(3, test.strongPasswordChecker("aaaaabbbb1234567890ABA"));
        assertEquals(5, test.strongPasswordChecker("aaaaAAAAAA000000123456"));
        assertEquals(8, test.strongPasswordChecker("bbaaaaaaaaaaaaaaacccccc"));
        assertEquals(7, test.strongPasswordChecker("333444455555333444455555"));
        assertEquals(6, test.strongPasswordChecker("4444aa2344444444aa234444"));
        assertEquals(5, test.strongPasswordChecker("4244aa2344244244aa234424"));
        assertEquals(8, test.strongPasswordChecker("aaaabbbbccccddeeddeeddeedd"));
        assertEquals(12, test.strongPasswordChecker("aaaaaaAAAAAA6666bbbbaaaaaaABBC"));
        assertEquals(13, test.strongPasswordChecker("aaaaaaaAAAAAA6666bbbbaaaaaaABBC"));
        assertEquals(23, test.strongPasswordChecker("FFFFFFFFFFFFFFF11111111111111111111AAA"));
    }
}