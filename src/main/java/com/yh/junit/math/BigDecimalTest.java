package com.yh.junit.math;

import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    @Test
    public void bgTest() {
        BigDecimal bg1 = new BigDecimal("10");
        BigDecimal bg2 = new BigDecimal("3");
        BigDecimal divide = bg1.divide(bg2, 4, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal divide2 = bg1.divide(bg2, 4, BigDecimal.ROUND_HALF_UP);
        BigDecimal bg3 = new BigDecimal("10");
        BigDecimal divide3 = bg3.divide(null, 4, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(divide);
        System.out.println(divide2);
        System.out.println(divide3);
    }
}
