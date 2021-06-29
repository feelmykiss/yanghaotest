package com.yh.junit.math;

import org.junit.Test;

/**
 * Test02 class
 *
 * @author yh
 * @date 2021/3/18
 */
public class Test02 {

    @Test
    public void test01() {
        double i1 = 5;
        double i2 = 2;
        double i = i1 / i2;
        double ceil = Math.ceil(i);
        System.out.println(i);
        System.out.println(ceil);
    }

    @Test
    public void test02() {
        int i1 = 7;
        int i2 = 20;
        double i = (double)i1 / (double)i2;
        System.out.println(i);
    }
}
