package com.alexkhromov.test.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FancyTest {

    private Fancy fancy = new Fancy();

    @Test
    public void test_1() {

        fancy.append(2);
        fancy.addAll(3);
        fancy.append(7);
        fancy.multAll(2);
        assertEquals(10, fancy.getIndex(0));
        fancy.addAll(3);
        fancy.append(10);
        fancy.multAll(2);
        assertEquals(26, fancy.getIndex(0));
        assertEquals(34, fancy.getIndex(1));
        assertEquals(20, fancy.getIndex(2));
    }

    @Test
    public void test_2() {

        fancy.append(2);
        fancy.append(5);
        fancy.append(7);
        fancy.append(6);
        fancy.addAll(8);
        fancy.addAll(5);
        assertEquals(15, fancy.getIndex(0));
        fancy.addAll(5);
        assertEquals(24, fancy.getIndex(3));
    }

    @Test
    public void test_3() {

        fancy.append(12);
        fancy.append(8);
        assertEquals(8, fancy.getIndex(1));
        fancy.append(12);
        fancy.addAll(12);
        fancy.append(8);
        assertEquals(24, fancy.getIndex(2));
        assertEquals(24, fancy.getIndex(2));
        fancy.append(4);
        fancy.append(13);
        assertEquals(4, fancy.getIndex(4));
        fancy.append(12);
        assertEquals(12, fancy.getIndex(6));
        fancy.append(11);
        assertEquals(20, fancy.getIndex(1));
        fancy.append(10);
        assertEquals(24, fancy.getIndex(2));
        fancy.multAll(3);
        fancy.addAll(1);
        assertEquals(37, fancy.getIndex(6));
        fancy.append(14);
        fancy.addAll(5);
        assertEquals(42, fancy.getIndex(6));
        fancy.multAll(12);
        assertEquals(360, fancy.getIndex(3));
        fancy.multAll(12);
        fancy.addAll(15);
        fancy.addAll(6);
        fancy.append(7);
        fancy.multAll(8);
        fancy.append(13);
        fancy.append(15);
        fancy.append(15);
        fancy.multAll(10);
        assertEquals(220560, fancy.getIndex(9));
        fancy.multAll(12);
        fancy.multAll(12);
        fancy.multAll(9);
        assertEquals(285845760, fancy.getIndex(9));
        fancy.addAll(9);
        fancy.append(9);
        fancy.multAll(4);
        fancy.addAll(8);
        fancy.addAll(11);
        fancy.multAll(15);
        fancy.addAll(9);
        fancy.addAll(1);
        fancy.append(4);
        fancy.append(10);
        assertEquals(150746316, fancy.getIndex(9));
    }
}