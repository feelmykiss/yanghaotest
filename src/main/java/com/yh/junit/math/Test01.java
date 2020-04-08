package com.yh.junit.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test01 {

    @Test
    public void test01() {
        long i = 162;
        long i1 = i / 60;
        long i2 = i % 60;
        System.out.println(i1);
        System.out.println(i2);
    }
    @Test
    public void test02() {
        long i = 1600;
        long i1 = 1500;
        long i2 = i/i1;
        System.out.println(i2);
    }

    @Test
    public void test03() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(1, 0);
        list.add(0, 123);
        System.out.println(list);
    }
}
